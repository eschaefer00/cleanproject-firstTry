package de.dhbw.cleanproject.application.todo;

import de.dhbw.cleanproject.domain.book.models.Todo;
import de.dhbw.cleanproject.domain.book.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoApplicationService {
    private final TodoRepository todoRepository;

    @Autowired
    public TodoApplicationService(TodoRepository todoRepository){this.todoRepository = todoRepository;}


    public List<Todo> findAllTodos(){return this.todoRepository.findAllTodos();}
}
