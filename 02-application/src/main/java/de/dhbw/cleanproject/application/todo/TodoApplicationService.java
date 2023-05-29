package de.dhbw.cleanproject.application.todo;

import de.dhbw.cleanproject.application.todo.data.CreateTodoData;
import de.dhbw.cleanproject.application.todo.data.UpdateTodoData;
import de.dhbw.cleanproject.domain.models.todo.Todo;
import de.dhbw.cleanproject.domain.repositories.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TodoApplicationService implements TodoApplication {
    private final TodoRepository todoRepository;

    @Override
    public List<Todo> findAllTodos(){
        return this.todoRepository.findAllTodos();
    }

    @Override
    public List<Todo> findAllTodosByCategoryAggregateId(UUID categoryAggregateId) {
        return todoRepository.findByCategoryAggregateId(categoryAggregateId);
    }

    @Override
    public Optional<Todo> findTodoById(UUID id){
        return this.todoRepository.findTodoById(id);
    }

    @Override
    public Optional<Todo> update(Todo todo, UpdateTodoData data){
        todoRepository.save(todo);
        return Optional.of(todo);
    }

    @Override
    public Optional<Todo> create(UUID categoryAggregateId, CreateTodoData data){
        Todo todo = Todo.TodoBuilder.create(data.getTitle(), data.getDescription(), data.getCategoryAggregateId(), data.getPriority(), data.getDeadline(), data.getStatus(), data.getPoints(), data.getScopeAggregateId());
        todoRepository.save(todo);
        return Optional.of(todo);
    }

    @Override
    public boolean existsByIds(UUID todoId, UUID categoryAggregateId) {
        return this.todoRepository.existsByIds(todoId, categoryAggregateId);
    }

    @Override
    public Todo save(Todo todo){
        return this.todoRepository.save(todo);
    }

    @Override
    public boolean delete(UUID userId, UUID todoId) {
        //todo: check if todo exists for particular user
        Optional<Todo> todo = findTodoById(todoId);
        if(todo.isPresent()){
            this.todoRepository.deleteById(todoId);
            return true;
        }
        return false;
    }
}