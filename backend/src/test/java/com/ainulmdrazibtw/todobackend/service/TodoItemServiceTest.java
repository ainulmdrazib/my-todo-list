package com.ainulmdrazibtw.todobackend.service;

import com.ainulmdrazibtw.todobackend.entity.TodoItemDetails;
import com.ainulmdrazibtw.todobackend.repository.TodoItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TodoItemServiceTest {

    @Mock
    TodoItemRepository testTodoItemRepository;

    @InjectMocks
    TodoItemService testTodoItemService;

    @Test
    public void shouldCreateTodoGivenValidTitle() {
        TodoItemDetails testTodoItem = new TodoItemDetails();
        testTodoItem.setTitle("todo 1");

        when(testTodoItemRepository.saveAndFlush(any(TodoItemDetails.class))).thenReturn(testTodoItem);

        TodoItemDetails createdTodo = testTodoItemService.createTodo("todo 1");

        assertNotNull(createdTodo);
        assertEquals(testTodoItem.getTitle(), createdTodo.getTitle());
    }

    @Test
    public void shouldRejectTodoGivenEmptyTitle() {
        TodoItemDetails createdTodo = testTodoItemService.createTodo("");

        assertNull(createdTodo);
    }


}
