package com.ainulmdrazibtw.todobackend.service;

import com.ainulmdrazibtw.todobackend.entity.TodoItemDetails;
import com.ainulmdrazibtw.todobackend.repository.TodoItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TodoItemServiceTest {

    @Mock
    TodoItemRepository testTodoItemRepository;

    @InjectMocks
    TodoItemService testTodoItemService;

    private String testTodoItemId = "111";

    @Test
    public void shouldCreateTodoGivenValidTitle() {
        TodoItemDetails testTodoItem = new TodoItemDetails();
        testTodoItem.setTitle("todo 1");

        when(testTodoItemRepository.save(any(TodoItemDetails.class))).thenReturn(testTodoItem);

        TodoItemDetails createdTodo = testTodoItemService.createTodo("todo 1");

        assertNotNull(createdTodo);
        assertEquals(testTodoItem.getTitle(), createdTodo.getTitle());
    }

    @Test
    public void shouldRejectTodoGivenEmptyTitle() {
        TodoItemDetails createdTodo = testTodoItemService.createTodo("");

        assertNull(createdTodo);
    }

    @Test
    public void shouldReturnAllTodos() {

        List<TodoItemDetails> testTodoItems = Arrays.asList(new TodoItemDetails(),
                                                            new TodoItemDetails(),
                                                            new TodoItemDetails());
        when(testTodoItemRepository.findAll()).thenReturn(testTodoItems);

        List<TodoItemDetails> testTodoList = testTodoItemService.getTodos();

        assertNotNull(testTodoList);
        assertEquals(testTodoItems.size(), testTodoList.size());
    }
    @Test
    public void shouldToggleTodoGivenValidId() {

        TodoItemDetails todoToggle = new TodoItemDetails();
        todoToggle.setId(testTodoItemId);

        when(testTodoItemRepository.findById(any(String.class))).thenReturn(Optional.of(todoToggle));
        when(testTodoItemRepository.save(any(TodoItemDetails.class))).thenReturn(todoToggle);

        TodoItemDetails toggledTodo = testTodoItemService.toggleTodo(todoToggle.getId());
        assertEquals(true, toggledTodo.getCompleted());
        toggledTodo = testTodoItemService.toggleTodo(todoToggle.getId());
        assertEquals(false, toggledTodo.getCompleted());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnErrorGivenNonexistentId() {
        TodoItemDetails toggledTodo = testTodoItemService.toggleTodo(testTodoItemId);
    }

    @Test
    public void shouldDeleteTodoGivenValidId() {
        TodoItemDetails todoDelete = new TodoItemDetails();
        todoDelete.setId(testTodoItemId);

        when(testTodoItemRepository.findById(any(String.class))).thenReturn(Optional.of(todoDelete));
        String message = testTodoItemService.deleteTodo(todoDelete.getId());

        Mockito.verify(testTodoItemRepository).deleteById(todoDelete.getId());
        assertEquals(testTodoItemId + " is deleted.", message);
    }

}
