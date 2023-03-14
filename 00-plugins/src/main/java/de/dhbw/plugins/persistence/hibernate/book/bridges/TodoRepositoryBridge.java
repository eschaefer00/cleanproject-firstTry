package de.dhbw.plugins.persistence.hibernate.book.bridges;

import de.dhbw.cleanproject.domain.book.models.Todo;
import de.dhbw.cleanproject.domain.book.repositories.TodoRepository;
import de.dhbw.plugins.persistence.hibernate.book.springdata.SpringDataTodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class TodoRepositoryBridge implements TodoRepository {
    private final SpringDataTodoRepository springDataTodoRepository;

    @Autowired
    public TodoRepositoryBridge(final SpringDataTodoRepository springDataTodoRepository) {
        this.springDataTodoRepository = springDataTodoRepository;
    }
    @Override
    public List<Todo> findAllTodos() {
        return this.springDataTodoRepository.findAllTodos();
    }

    @Override
    public List<Todo> findTodoByCategory(int category) {
        return this.springDataTodoRepository.findTodoByCategory(category);
    }

    @Override
    public Todo findTodoById(UUID id) {
        return this.springDataTodoRepository.findTodoById(id);
    }

    @Override
    public Todo save(final Todo todo) {
        return this.springDataTodoRepository.save(todo);
    }

}
