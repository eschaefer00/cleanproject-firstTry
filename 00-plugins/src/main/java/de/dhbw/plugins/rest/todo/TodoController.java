package de.dhbw.plugins.rest.todo;

import de.dhbw.cleanproject.adapter.mappers.todo.update.RawToUpdateTodoDataMapper;
import de.dhbw.cleanproject.application.category.CategoryApplication;
import de.dhbw.cleanproject.application.todo.TodoApplication;
import de.dhbw.cleanproject.domain.models.todo.Todo;
import de.dhbw.plugins.rest.todo.data.UpdateTodoData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/user/{userId}/category/{categoryAggregateId}/todo/{todoId}")
@RequiredArgsConstructor
public class TodoController {

    private final TodoApplication todoApplication;
    private final RawToUpdateTodoDataMapper rawToUpdateTodoDataMapper;
    private final CategoryApplication categoryApplication;

    @GetMapping
    public ResponseEntity<Todo> findOne(@PathVariable("todoId") UUID todoId, @PathVariable("categoryAggregateId") UUID categoryAggregateId, @PathVariable("userId") UUID userId) {
        if (!categoryApplication.existsByIds(categoryAggregateId, userId)) return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        Optional<Todo> optionalTodo = todoApplication.findTodoById(todoId);
        return optionalTodo.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.FORBIDDEN));
    }

    @PatchMapping
    public ResponseEntity<Todo> update(@PathVariable("userId") UUID userId, @PathVariable("categoryAggregateId") UUID categoryAggregateId, @PathVariable("todoId") UUID todoId, @Valid @RequestBody UpdateTodoData data) {
        if (!categoryApplication.existsByIds(categoryAggregateId, userId)) return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        if (!todoApplication.existsByIds(todoId, categoryAggregateId)) return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        Optional<Todo> optionalTodo = todoApplication.findTodoById(todoId);
        if (optionalTodo.isEmpty()) return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        optionalTodo = todoApplication.update(optionalTodo.get(), rawToUpdateTodoDataMapper.apply(data));
        return optionalTodo.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable("userId") UUID userId, @PathVariable("todoId") UUID todoId) {
        if (!todoApplication.delete(userId, todoId)) return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
