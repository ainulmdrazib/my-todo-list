package com.ainulmdrazibtw.mytodolist.repository

import com.ainulmdrazibtw.mytodolist.entity.TodoItemDetails

class TodoItemRepositoryImpl: TodoItemRepository {
    val DEFAULT_USERNAME = "user123"

    override fun getAllTodos(): List<TodoItemDetails> {
        return listOf(
            TodoItemDetails("Test todo 1", false, DEFAULT_USERNAME),
            TodoItemDetails("Test todo 2",false, DEFAULT_USERNAME),
            TodoItemDetails("Test todo 3",false, DEFAULT_USERNAME)
        )
    }
}