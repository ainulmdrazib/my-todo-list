package com.ainulmdrazibtw.todobackend.service;

import com.ainulmdrazibtw.todobackend.entity.TodoItemDetails;
import com.ainulmdrazibtw.todobackend.entity.UserDetails;
import com.ainulmdrazibtw.todobackend.repository.TodoItemRepository;

import java.util.Optional;

public class TodoItemService {
    private TodoItemRepository todoItemRepository;

    public TodoItemDetails createTodo(String title){

        if (!title.isEmpty()){
            TodoItemDetails todoCreate = new TodoItemDetails();
            todoCreate.setTitle(title);

            return todoItemRepository.saveAndFlush(todoCreate);
        } else {
            return null;
        }
    }

    public TodoItemDetails toggleTodo(Integer todoToggleId) {

        TodoItemDetails todoToggle = todoItemRepository.findById(todoToggleId).orElse(null);
        if (todoToggle != null) {
            todoToggle.setCompleted(!todoToggle.getCompleted());
            return todoItemRepository.saveAndFlush(todoToggle);

        } else {
            throw new IllegalArgumentException("Todo item does not exist");

        }
    }

    public void deleteTodo(Integer todoDeleteId) {
        todoItemRepository.deleteById(todoDeleteId);
    }
}
