package de.dhbw.plugins.rest.model.todo.mapper;

import de.dhbw.cleanproject.domain.models.todo.Todo;
import de.dhbw.plugins.rest.model.todo.TodoPreviewModel;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TodoToPreviewModelMapper implements Function<Todo, TodoPreviewModel> {

    @Override
    public TodoPreviewModel apply(final Todo todo) {
        return map(todo);
    }

    private TodoPreviewModel map(final Todo todo) {
        return TodoPreviewModel.builder().id(todo.getId()).title(todo.getTitle()).build();
    }
}
