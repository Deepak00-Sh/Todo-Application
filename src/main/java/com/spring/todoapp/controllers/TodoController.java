package com.spring.todoapp.controllers;

import com.spring.todoapp.service.TodoService;
import com.spring.todoapp.todo.Todo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
    public String showTodoPage(ModelMap modelMap){
        Todo todo = new Todo(0,(String)modelMap.get("name"),"",LocalDate.now().plusYears(1),false);
        modelMap.put("todo",todo);
        return "todo";
    }
    @RequestMapping(value = "addTodo", method = RequestMethod.POST)
    public String addTodo(ModelMap modelMap, @Valid Todo todo, BindingResult result){
        String userName = (String) modelMap.get("name");
        if (result.hasErrors()){
            return "todo";
        }
        todoService.addTodo(userName,todo.getDescription(), LocalDate.now().plusMonths(2),false);
        return "redirect:list-todos";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id){
        todoService.deleteTodoById(id);
        return "redirect:list-todos";
    }
}
