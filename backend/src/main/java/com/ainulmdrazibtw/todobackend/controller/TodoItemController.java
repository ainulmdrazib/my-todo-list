package com.ainulmdrazibtw.todobackend.controller;

import com.ainulmdrazibtw.todobackend.entity.TodoItemDetails;
import com.ainulmdrazibtw.todobackend.service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = { "http://localhost:3000"})
public class TodoItemController {

    @Autowired
    private TodoItemService todoItemService;

//    @GetMapping("/todosByUser/{username}")
//    private List<TodoItemDetails> getUserTodos(@PathVariable String userame){
//        return todoItemService.getUserTodos(userame);
//    }

    @PostMapping("/createTodo")
    public TodoItemDetails createTodoItem(@RequestBody TodoItemDetails todoDetailsCreate){
        return todoItemService.createTodo(todoDetailsCreate.getTitle());
    }
    @PostMapping("/toggleTodo")
    public TodoItemDetails toggleTodoItem(@RequestBody TodoItemDetails todoDetailsToggle){
        return todoItemService.toggleTodo(todoDetailsToggle.getId());
    }
    @PostMapping("/deleteTodo")
    public String deleteTodoItem(@RequestBody TodoItemDetails todoDetailsToggle){
        return todoItemService.deleteTodo(todoDetailsToggle.getId());
    }
    @GetMapping("/allTodos")
    public List<TodoItemDetails> retrieveAllTodos(){
        return todoItemService.getTodos();
    }

}
