package SpringBoot1.TodoList40.contoller;




import SpringBoot1.TodoList40.model.Todo;
import SpringBoot1.TodoList40.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping
    public String listTodos(Model model) {
        List<Todo> todos = todoRepository.findAll();
        model.addAttribute("todos", todos);
        return "todosview";
    }

    @PostMapping
    public String addTodo(@RequestParam String task) {
        Todo todo = new Todo();
        todo.setTask(task);
        todo.setCompleted(false);
        todoRepository.save(todo);
        return "redirect:/todos";
    }

    @PostMapping("/complete/{id}")
    public String completeTodo(@PathVariable Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow();
        todo.setCompleted(true);
        todoRepository.save(todo);
        return "redirect:/todos";
    }

    @PostMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        todoRepository.deleteById(id);
        return "redirect:/todos";
    }
}