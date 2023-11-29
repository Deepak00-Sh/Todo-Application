package com.spring.todoapp.service;

import com.spring.todoapp.todo.Todo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int todosCount = 0;

    static {
        todos.add(new Todo(++todosCount,"Deepak","Learn AWS", LocalDate.now().plusYears(1),false));
        todos.add(new Todo(++todosCount,"Deepak","Learn Azure", LocalDate.now().plusYears(1),false));
        todos.add(new Todo(++todosCount,"Deepak","Learn Springboot", LocalDate.now().plusYears(1),false));
    }
    public void addTodo(String userName, String description, LocalDate targetDate, boolean isDone){
        Todo todo = new Todo(++todosCount,userName, description, targetDate, isDone);
        todos.add(todo);
    }
    public List<Todo> findByUserName(String userName){
        return todos;
    }

    public void deleteTodoById(int id){
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
        todosCount = todosCount -1;
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        return todos.stream().filter(predicate).findFirst().get();
    }

    public void updateById(Todo todo, String description,LocalDate targetDate){
        deleteTodoById(todo.getId());
        addTodo(todo.getUserName(),todo.getDescription(),todo.getTargetDate(),false);
    }

}
class SortTodosById implements Comparator<Todo>{
    @Override
    public int compare(Todo o1, Todo o2) {
        return o1.getId() - o2.getId();
    }
}
