package com.ainulmdrazibtw.todobackend.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import com.ainulmdrazibtw.todobackend.TodobackendApplication;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import com.ainulmdrazibtw.todobackend.entity.TodoItemDetails;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//@SpringBootTest(classes = TodobackendApplication.class)
@DataMongoTest
public class TodoItemRepositoryTests {

    @Autowired
    private TodoItemRepository testTodoItemRepository;


    private String testTodoItemId = "111";
    @Test
    public void shouldSaveAndRetrieveTodoItem() {
        TodoItemDetails testTodoItemDetails = new TodoItemDetails();

        testTodoItemDetails.setTitle("Todo item 1");
        testTodoItemDetails.setId(testTodoItemId);
        testTodoItemDetails.setUsername("user00");
        testTodoItemDetails.setCompleted(false);

        testTodoItemRepository.save(testTodoItemDetails);

        List<TodoItemDetails> foundTodoItemDetailsList = testTodoItemRepository.findAllByUsername("user00");

        assertEquals(foundTodoItemDetailsList.contains(testTodoItemDetails), true);        
    }
    
}
