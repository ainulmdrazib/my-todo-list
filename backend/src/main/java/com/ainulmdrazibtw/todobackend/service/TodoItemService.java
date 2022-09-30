package com.ainulmdrazibtw.todobackend.service;

import com.ainulmdrazibtw.todobackend.entity.TodoItemDetails;
import com.ainulmdrazibtw.todobackend.entity.UserDetails;
import com.ainulmdrazibtw.todobackend.repository.TodoItemRepository;

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
}
