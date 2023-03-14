package de.dhbw.cleanproject.domain.book.repositories;

import de.dhbw.cleanproject.domain.book.models.Todo;

import java.util.List;

public interface TodoRepository {
    List<Todo> findAllTodos();

    List<Todo> findTodoByCategory(int category);//or real text? how would that link work then

    Todo findTodoById();

    Todo save(Todo todo);

}
