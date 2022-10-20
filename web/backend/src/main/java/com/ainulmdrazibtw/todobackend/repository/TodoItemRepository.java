package com.ainulmdrazibtw.todobackend.repository;

import java.util.List;


import com.ainulmdrazibtw.todobackend.entity.TodoItemDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoItemRepository extends MongoRepository<TodoItemDetails, String> {

    List<TodoItemDetails> findAllByUsername(String username);

    
}
