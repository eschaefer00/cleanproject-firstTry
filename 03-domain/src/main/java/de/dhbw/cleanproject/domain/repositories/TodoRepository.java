package de.dhbw.cleanproject.domain.repositories;

import de.dhbw.cleanproject.domain.models.todo.PriorityTodo;
import de.dhbw.cleanproject.domain.models.todo.Todo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TodoRepository {
    List<Todo> findAllTodos();

    List<Todo> findByCategoryAggregateId(UUID categoryAggregateId);

    List<Todo> findTodoByPriority(PriorityTodo priority);

    Optional<Todo> findTodoById(UUID id);

    boolean existsByIds(UUID todoId, UUID categoryAggregateId);

    Todo save(Todo todo);

    void deleteById(UUID todoId);
}
