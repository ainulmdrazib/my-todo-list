package com.ainulmdrazibtw.todobackend.controller;

import com.ainulmdrazibtw.todobackend.entity.TodoItemDetails;
import com.ainulmdrazibtw.todobackend.service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = { "http://localhost:3000"})
public class TodoItemController {

    @Autowired
    private TodoItemService todoItemService;

    @PostMapping("/createTodo")
    public TodoItemDetails createTodoItem(@RequestBody TodoItemDetails todoDetailsCreate){
        return todoItemService.createTodo(todoDetailsCreate.getTitle());
    }
    @PostMapping("/toggleTodo")
    public TodoItemDetails toggleTodoItem(@RequestBody TodoItemDetails todoDetailsToggle){
        return todoItemService.toggleTodo(todoDetailsToggle.getId());
    }
    @PostMapping("/deleteTodo")
    public ResponseEntity deleteTodoItem(@RequestBody TodoItemDetails todoDetailsToggle){

       String responseMessage = todoItemService.deleteTodo(todoDetailsToggle.getId());

       if (responseMessage != null){
           return ResponseEntity
                   .status(HttpStatus.ACCEPTED)
                   .body(responseMessage);
       } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("This todo does not exist, or the server is down.");
        }
    }
    @GetMapping("/allTodos")
    public List<TodoItemDetails> retrieveAllTodos(){
        return todoItemService.getTodos();
    }

}
