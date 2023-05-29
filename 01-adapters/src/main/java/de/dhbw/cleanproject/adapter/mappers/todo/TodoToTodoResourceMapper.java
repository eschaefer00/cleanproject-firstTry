package de.dhbw.cleanproject.adapter.mappers.todo;

import de.dhbw.cleanproject.adapter.resources.TodoResource;
import de.dhbw.cleanproject.domain.models.todo.Todo;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TodoToTodoResourceMapper implements Function<Todo, TodoResource> {
    @Override
    public TodoResource apply(final Todo todo){
        return map(todo);
    }

    private TodoResource map(final Todo todo){
        return new TodoResource(todo.getTitle(), todo.getDescription(), todo.getCategoryAggregateId(), todo.getPriority(), todo.getDeadline(), todo.getStatus(), todo.getScopeAggregateId());
    }
}