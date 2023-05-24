package de.dhbw.plugins.rest.todos;

import de.dhbw.cleanproject.adapter.mappers.todo.create.RawToCreateTodoDataMapper;
import de.dhbw.cleanproject.application.todo.TodoApplication;
import de.dhbw.cleanproject.application.category.CategoryApplication;
import de.dhbw.cleanproject.domain.models.todo.Todo;
import de.dhbw.plugins.rest.model.todo.TodoPreviewModel;
import de.dhbw.plugins.rest.model.todo.mapper.TodoToPreviewModelMapper;
import de.dhbw.plugins.rest.todo.data.CreateTodoData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/user/{userId}/category/{categoryAggregateId}/todos")
@RequiredArgsConstructor
public class TodosController {

    private final TodoApplication todoApplication;
    private final CategoryApplication categoryApplication;
    private final TodoToPreviewModelMapper todoToPreviewModelMapper;
    private final RawToCreateTodoDataMapper rawToCreateTodoDataMapper;

    @GetMapping("/")
    public ResponseEntity<List<TodoPreviewModel>> listAll(@PathVariable("userId") UUID userId, @PathVariable("categoryAggregateId") UUID categoryAggregateId) {
        if (!categoryApplication.existsByIds(categoryAggregateId, userId)) return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        List<TodoPreviewModel> result = todoApplication.findAllTodosByCategoryAggregateId(categoryAggregateId).stream().map(todoToPreviewModelMapper::apply).collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }


}
