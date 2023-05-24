package de.dhbw.plugins.persistence.hibernate.bridges;

import de.dhbw.cleanproject.domain.models.todo.PriorityTodo;
import de.dhbw.cleanproject.domain.models.todo.Todo;
import de.dhbw.cleanproject.domain.repositories.TodoRepository;
import de.dhbw.plugins.persistence.hibernate.springdata.SpringDataTodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class TodoRepositoryBridge implements TodoRepository {
    private final SpringDataTodoRepository springDataTodoRepository;

    @Override
    public List<Todo> findAllTodos() {
        return this.springDataTodoRepository.findAll();
    }

    @Override
    public List<Todo> findByCategoryAggregateId(UUID categoryAggregateId) {
        return this.springDataTodoRepository.findByCategoryAggregateId(categoryAggregateId);
    }

    @Override
    public List<Todo> findTodoByPriority(PriorityTodo priority){
        return this.springDataTodoRepository.findTodoByPriority(priority);
    }

    @Override
    public Optional<Todo> findTodoById(UUID id) {
        return this.springDataTodoRepository.findById(id);
    }

    @Override
    public boolean existsByIds(UUID id, UUID categoryAggregateId) {
        return springDataTodoRepository.findByIdWithCategoryAggregateId(id, categoryAggregateId).size() > 0;
    }

    @Override
    public Todo save(final Todo todo) {
        return this.springDataTodoRepository.save(todo);
    }

}
