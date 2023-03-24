package de.dhbw.cleanproject.application;

import de.dhbw.cleanproject.application.todo.data.CreateTodoData;
import de.dhbw.cleanproject.domain.models.todo.Todo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TodoApplication {


    List<Todo> findAllTodos();

    List<Todo> findAllTodosByCategoryAggregateId(UUID categoryAggregateId);

    Optional<Todo> findTodoById(UUID id);

    Optional<Todo> create(UUID categoryAggregateId, CreateTodoData data);

    Todo save(Todo todo);
}
