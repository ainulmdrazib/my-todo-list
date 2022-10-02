package com.ainulmdrazibtw.todobackend.service;

import com.ainulmdrazibtw.todobackend.entity.TodoItemDetails;
import com.ainulmdrazibtw.todobackend.repository.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoItemService {
    @Autowired
    private TodoItemRepository todoItemRepository;

    public TodoItemDetails createTodo(String title){

        if (!title.isEmpty()){
            TodoItemDetails todoCreate = new TodoItemDetails();
            todoCreate.setTitle(title);

            return todoItemRepository.save(todoCreate);
        } else {
            return null;
        }
    }
    public List<TodoItemDetails> getTodos(){
        return todoItemRepository.findAll();
    }

    public TodoItemDetails toggleTodo(String todoToggleId) {

        TodoItemDetails todoToggle = todoItemRepository.findById(todoToggleId).orElse(null);
        if (todoToggle != null) {
            todoToggle.setCompleted(!todoToggle.getCompleted());
            return todoItemRepository.save(todoToggle);

        } else {
            throw new IllegalArgumentException("Todo item does not exist");

        }
    }

    public String deleteTodo(String todoDeleteId) {
        TodoItemDetails todoDelete = todoItemRepository.findById(todoDeleteId).orElse(null);

        if (todoDelete != null){
            todoItemRepository.deleteById(todoDeleteId);
            return todoDeleteId + " is deleted.";
        } else {
            return null;
        }

    }
}
