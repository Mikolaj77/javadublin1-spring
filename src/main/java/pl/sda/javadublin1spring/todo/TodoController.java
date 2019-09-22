package pl.sda.javadublin1spring.todo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/todo") //jezeli mapping jest na poziomie klasy jest to prefix do pozostalych

public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ModelAndView allTodo() { // widok w katalogu todo
        ModelAndView modelAndView = new ModelAndView("todo/todos-view");
        modelAndView.addObject("todos", todoService.findAll());
        return modelAndView;
    }
}
