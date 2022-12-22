package com.ainulmdrazibtw.mytodolist.view

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.ainulmdrazibtw.mytodolist.entity.TodoItemDetails
import com.ainulmdrazibtw.mytodolist.repository.TodoItemRepositoryImpl

class TodoItemListViewModel : ViewModel() {
    private val todoItemRepository = TodoItemRepositoryImpl()
    var todoItems =  mutableStateListOf<TodoItemDetails>()
    var DEFAULT_USERNAME: String = "User123"

    fun retrieveTodoInit(): List<TodoItemDetails>? {
        try {
            val todosFromRepo = todoItemRepository.getAllTodos()

            if (todosFromRepo.isNotEmpty() && todoItems.isEmpty()) {
                todosFromRepo.forEach {
                    todoItems.add(it)
                }
            }
            return todoItems

        } catch (e:Exception) {
            return emptyList()
        }
    }

    fun addTodo(todoToAdd: TodoItemDetails): TodoItemDetails {
        todoItems.add(todoToAdd)

        return todoToAdd
    }
}