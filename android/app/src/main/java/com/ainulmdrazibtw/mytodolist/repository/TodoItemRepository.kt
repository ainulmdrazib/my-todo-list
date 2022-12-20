package com.ainulmdrazibtw.mytodolist.repository

import com.ainulmdrazibtw.mytodolist.entity.TodoItemDetails

interface TodoItemRepository {
    fun getAllTodos(): List<TodoItemDetails>
    fun addTodo( title: String): TodoItemDetails
}
