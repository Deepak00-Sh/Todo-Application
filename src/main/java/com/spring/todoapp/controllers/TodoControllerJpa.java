package com.spring.todoapp.controllers;

import com.spring.todoapp.repositories.TodoRepository;
import com.spring.todoapp.service.TodoService;
import com.spring.todoapp.todo.Todo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {
    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/list-todos")
    public String listAllTodos(ModelMap modelMap) {
        String userName = getLoggedInUsername();
        List<Todo> todos = todoRepository.findByUserName(userName);
        modelMap.put("todos", todos);
        return "listTodos";
    }

    @GetMapping(value = "addTodo")
    public String showTodoPage(ModelMap modelMap) {
        Todo todo = new Todo(0, (String) modelMap.get("name"), "", LocalDate.now().plusYears(1), false);
        modelMap.put("todo", todo);
        return "todo";
    }

    @PostMapping(value = "addTodo")
    public String addTodo(ModelMap modelMap, @Valid Todo todo, BindingResult result) {
        String userName = getLoggedInUsername();
        if (result.hasErrors()) {
            return "todo";
        }
        todo.setUserName(userName);
        todoRepository.save(todo);
        return "redirect:list-todos";
    }

    @GetMapping("delete-todo")
    public String deleteTodo(@RequestParam int id) {
        todoRepository.deleteById(id);
        return "redirect:list-todos";
    }

    @GetMapping(value = "update-todo")
    public String showUpdateTodoPage(@RequestParam int id, ModelMap map) {
        Todo todo = todoRepository.findById(id).get();
        map.addAttribute("todo", todo);
        return "todo";
    }

    @PostMapping(value = "update-todo")
    public String showUpdateTodoPage(ModelMap modelMap, @Valid Todo todo1, BindingResult result) {
        String userName = getLoggedInUsername();
        Todo todo = (Todo) modelMap.get("todo");
        todo.setUserName(userName);
        if (result.hasErrors()) {
            return "todo";
        }
        todoRepository.save(todo);
        return "redirect:list-todos";
    }


    private String getLoggedInUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
