package de.dhbw.plugins.rest.todo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/todo")
public class TodoController {

//    private final TodoApplication todoApplication;
//    private final TodoToTodoResourceMapper todoToTodoResourceMapper;
//
//    @Autowired
//    public TodoController(final TodoApplication todoApplication, final TodoToTodoResourceMapper todoToTodoResourceMapper) {
//        this.todoApplication = todoApplication;
//        this.todoToTodoResourceMapper = todoToTodoResourceMapper;
//    }
//
//    @RequestMapping(method = RequestMethod.GET)
//    public List<TodoResource> getTodos() {
//        return this.todoApplication.findAllTodos().stream().map(todoToTodoResourceMapper).collect(Collectors.toList());
//    }
//
//    @RequestMapping(method = RequestMethod.GET)
//    public TodoResource getTodo(UUID id) {
//       // return this.todoApplicationService.findTodoById(id).stream().map(todoToTodoResourceMapper);
//        return null;
//    }
//
//    @RequestMapping(method = RequestMethod.PUT)
//    public TodoResource createTodo(){
//        return null;
//    }
//
//    @RequestMapping(method = RequestMethod.DELETE)
//    public void deleteTodo(){
//    }
//
//    @RequestMapping(method = RequestMethod.PUT)
//    public TodoResource editTodo(UUID id){
//        //Todo todo = findTodoById(id);
//        // todo.title = here comes the user input
//        //return this.todoApplication.save(todo).map(todoToTodoResourceMapper);
//    }
//
//    public TodoResource categoriseTodo(){return null;}
//
//    public TodoResource setTodoToDone(){return null;}
//
//    public TodoResource addTodoToScope(){return null;}


}
