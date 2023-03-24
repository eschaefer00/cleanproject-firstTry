package de.dhbw.cleanproject.application.todo;

import de.dhbw.cleanproject.application.TodoApplication;
import de.dhbw.cleanproject.application.todo.data.CreateTodoData;
import de.dhbw.cleanproject.application.todo.data.UpdateTodoData;
import de.dhbw.cleanproject.domain.models.Category;
import de.dhbw.cleanproject.domain.models.todo.PriorityTodo;
import de.dhbw.cleanproject.domain.models.todo.Todo;
import de.dhbw.cleanproject.domain.repositories.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TodoApplicationService implements TodoApplication {
    private final TodoRepository todoRepository;

    @Autowired
    public TodoApplicationService(TodoRepository todoRepository){this.todoRepository = todoRepository;}


    public List<Todo> findAllTodos(){return this.todoRepository.findAllTodos();}

    public Optional<Todo> findTodoById(UUID id){
        return this.todoRepository.findTodoById(id);
    }

    public Optional<Todo> update(Todo todo, UpdateTodoData data){
        //todo
        return null;
    }

    public Optional<Todo> create(UUID categoryAggregateId, CreateTodoData data){
        //todo muss noch angepasst werden
        Todo todo = Todo.TodoBuilder.create(data.getTitle(), "description", categoryAggregateId, PriorityTodo.LOW, LocalDate.now(), 0, 0);
        todoRepository.save(todo);
        return Optional.of(todo);
    }

    public Todo save(Todo todo){
        return this.todoRepository.save(todo);
    }
}
