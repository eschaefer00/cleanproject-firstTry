package de.dhbw.plugins.rest;

import de.dhbw.cleanproject.adapter.book.mappers.TodoToTodoResourceMapper;
import de.dhbw.cleanproject.adapter.book.resources.TodoResource;
import de.dhbw.cleanproject.application.todo.TodoApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/todo")
public class TodoController {

    private final TodoApplicationService todoApplicationService;
    private final TodoToTodoResourceMapper todoToTodoResourceMapper;

    @Autowired
    public TodoController(final TodoApplicationService todoApplicationService, final TodoToTodoResourceMapper todoToTodoResourceMapper) {
        this.todoApplicationService = todoApplicationService;
        this.todoToTodoResourceMapper = todoToTodoResourceMapper;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<TodoResource> getTodos() {
        return this.todoApplicationService.findAllTodos().stream().map(todoToTodoResourceMapper).collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET)
    public TodoResource getTodo(UUID id) {
       // return this.todoApplicationService.findTodoById(id).stream().map(todoToTodoResourceMapper);
        return null;
    }

}
