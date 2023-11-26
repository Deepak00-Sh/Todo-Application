package com.spring.todoapp.controllers;

import com.spring.todoapp.service.TodoService;
import com.spring.todoapp.todo.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
public class TodoController {
    @Autowired
    private TodoService todoService;
    @RequestMapping("/list-todos")
    public String listAllTodos(ModelMap modelMap) {
        List<Todo> todos = todoService.findByUserName("Deepak");
            modelMap.put("todos" , todos);
        return "listTodos";
    }
    @RequestMapping(value = "addTodo", method = RequestMethod.GET)
    public String showTodoPage(){
        return "todo";
    }
    @RequestMapping(value = "addTodo", method = RequestMethod.POST)
    public String addTodo(@RequestParam String description,ModelMap modelMap){
        String userName = (String) modelMap.get("name");
        todoService.addTodo(userName,description, LocalDate.now().plusMonths(2),false);
        return "redirect:list-todos";
    }
}
