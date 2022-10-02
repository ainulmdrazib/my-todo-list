package com.ainulmdrazibtw.todobackend.controller;

import com.ainulmdrazibtw.todobackend.entity.TodoItemDetails;
import com.ainulmdrazibtw.todobackend.service.TodoItemService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(TodoItemController.class)
@AutoConfigureDataMongo
public class TodoItemControllerTests {

    @MockBean
    TodoItemService testTodoItemService;

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    private String testTodoItemId = "111";

    @Test
    public void shouldCreateTodoGivenValidDetails() throws Exception {
        TodoItemDetails todoItemDetailsCreate = new TodoItemDetails();

        todoItemDetailsCreate.setId(testTodoItemId);
        todoItemDetailsCreate.setTitle("todo item");
        todoItemDetailsCreate.setUsername("someuser");

        when(testTodoItemService.createTodo(any(String.class))).thenReturn(todoItemDetailsCreate);

        mockMvc.perform(post("/createTodo")
                        .content(mapper.writeValueAsString(todoItemDetailsCreate))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value(todoItemDetailsCreate.getUsername()));
    }
    @Test
    public void shouldToggleTodoGivenValidDetails() throws Exception {
        TodoItemDetails todoItemDetailsBeforeToggle = new TodoItemDetails();

        todoItemDetailsBeforeToggle.setId(testTodoItemId);

        TodoItemDetails todoItemDetailsAfterToggle = new TodoItemDetails();
        todoItemDetailsAfterToggle.setCompleted(true);
        todoItemDetailsBeforeToggle.setId(testTodoItemId);

        when(testTodoItemService.toggleTodo(any(String.class))).thenReturn(todoItemDetailsAfterToggle);

        mockMvc.perform(post("/toggleTodo")
                        .content(mapper.writeValueAsString(todoItemDetailsBeforeToggle))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.completed").value(String.valueOf(todoItemDetailsAfterToggle.getCompleted())));
    }
    @Test
    public void shouldDeleteTodoGivenValidDetails() throws Exception {
        TodoItemDetails todoItemDetailsDelete = new TodoItemDetails();

        todoItemDetailsDelete.setId(testTodoItemId);

        when(testTodoItemService.deleteTodo(any(String.class))).thenReturn(todoItemDetailsDelete.getId() + " is deleted");

        mockMvc.perform(post("/deleteTodo")
                        .content(mapper.writeValueAsString(todoItemDetailsDelete))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void shouldReturn500ErrorGivenInvalidId() throws Exception {
        TodoItemDetails todoItemDetailsDelete = new TodoItemDetails();

        todoItemDetailsDelete.setId(testTodoItemId);

        when(testTodoItemService.deleteTodo(any(String.class))).thenReturn(null);

        mockMvc.perform(post("/deleteTodo")
                        .content(mapper.writeValueAsString(todoItemDetailsDelete))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is5xxServerError());
    }
    @Test
    public void shouldRetrieveAllTodos() throws Exception {

        List<TodoItemDetails> testTodos =Arrays.asList(new TodoItemDetails(),new TodoItemDetails(),new TodoItemDetails());

        when(testTodoItemService.getTodos()).thenReturn(testTodos);

        MvcResult response = mockMvc.perform(get("/allTodos")
                        .accept(MediaType.APPLICATION_JSON))
                        .andReturn();

        assertEquals(HttpStatus.OK.value(), response.getResponse().getStatus());
    }
}
