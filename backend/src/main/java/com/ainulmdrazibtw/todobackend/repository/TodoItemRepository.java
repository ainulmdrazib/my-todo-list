package com.ainulmdrazibtw.todobackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ainulmdrazibtw.todobackend.entity.TodoItemDetails;

public interface TodoItemRepository extends JpaRepository<TodoItemDetails, Integer> {

    List<TodoItemDetails> findAllByUsername(String username);

    
}
