package com.spring.todoapp.service;

import com.spring.todoapp.todo.Todo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    static {
        todos.add(new Todo(1,"Deepak","Learn AWS", LocalDate.now().plusYears(1),false));
        todos.add(new Todo(2,"Deepak","Learn Azure", LocalDate.now().plusYears(1),false));
        todos.add(new Todo(3,"Deepak","Learn Springboot", LocalDate.now().plusYears(1),true));
    }
    public List<Todo> findByUserName(String userName){
        return todos;
    }

}
