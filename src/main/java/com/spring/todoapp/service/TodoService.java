package com.spring.todoapp.service;

import com.spring.todoapp.todo.Todo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();

    private static int todosCount = 0;
    static {
        todos.add(new Todo(++todosCount,"Deepak","Learn AWS", LocalDate.now().plusYears(1),false));
        todos.add(new Todo(++todosCount,"Deepak","Learn Azure", LocalDate.now().plusYears(1),false));
        todos.add(new Todo(++todosCount,"Deepak","Learn Springboot", LocalDate.now().plusYears(1),true));
    }
    public void addTodo(String userName, String description, LocalDate targetDate, boolean isDone){
        Todo todo = new Todo(++todosCount,userName, description, targetDate, isDone);
        todos.add(todo);
    }
    public List<Todo> findByUserName(String userName){
        return todos;
    }

}
