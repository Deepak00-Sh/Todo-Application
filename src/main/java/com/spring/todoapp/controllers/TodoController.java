package com.spring.todoapp.controllers;

import com.spring.todoapp.service.TodoService;
import com.spring.todoapp.todo.Todo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class TodoController {
    @Autowired
    private TodoService todoService;
    @GetMapping("/list-todos")
    public String listAllTodos(ModelMap modelMap) {
        List<Todo> todos = todoService.findByUserName("Deepak");
            modelMap.put("todos" , todos);
        return "listTodos";
    }
    @GetMapping(value = "addTodo")
    public String showTodoPage(ModelMap modelMap){
        Todo todo = new Todo(0,(String)modelMap.get("name"),"",LocalDate.now().plusYears(1),false);
        modelMap.put("todo",todo);
        return "todo";
    }
    @PostMapping(value = "addTodo")
    public String addTodo(ModelMap modelMap, @Valid Todo todo, BindingResult result){
        String userName = (String) modelMap.get("name");
        if (result.hasErrors()){
            return "todo";
        }
        todoService.addTodo(userName,todo.getDescription(), LocalDate.now().plusMonths(2),false);
        return "redirect:list-todos";
    }

    @GetMapping("delete-todo")
    public String deleteTodo(@RequestParam int id){
        todoService.deleteTodoById(id);
        return "redirect:list-todos";
    }
    @GetMapping(value = "update-todo")
    public String showUpdateTodoPage(@RequestParam int id, ModelMap map){
        Todo todo = todoService.findById(id);
        map.addAttribute("todo",todo);
        return "todo";
    }
    @PostMapping(value = "update-todo")
    public String showUpdateTodoPage(ModelMap modelMap, @Valid Todo todo1, BindingResult result){
        String userName = (String) modelMap.get("name");
        Todo todo = (Todo) modelMap.get("todo");
        if (result.hasErrors()){
            return "todo";
        }
        todoService.updateById(todo, todo.getDescription(),todo.getTargetDate());
        return "redirect:list-todos";
    }
}
