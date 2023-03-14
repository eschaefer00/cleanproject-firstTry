package de.dhbw.cleanproject.adapter.book.mappers;

import de.dhbw.cleanproject.adapter.book.resources.BookResource;
import de.dhbw.cleanproject.adapter.book.resources.TodoResource;
import de.dhbw.cleanproject.domain.book.models.Book;
import de.dhbw.cleanproject.domain.book.models.Todo;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TodoToTodoResourceMapper implements Function<Todo, TodoResource> {

    @Override
    public TodoResource apply(final Todo todo) {
        return map(todo);
    }

    private TodoResource map(final Todo todo) {
        return new TodoResource(todo.getTitle(), todo.getDescription(), todo.getCategory(), todo.getPriority(), todo.getDeadline(), todo.getStatus());
    }
}
