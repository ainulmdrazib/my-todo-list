package com.ainulmdrazibtw.mytodolist.view

import androidx.lifecycle.ViewModel
import com.ainulmdrazibtw.mytodolist.repository.TodoItemRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow

class TodoItemListViewModel(
//    private val todoItemRepository: TodoItemRepositoryImpl
) : ViewModel() {
    private val todoItemRepository = TodoItemRepositoryImpl()
    val todoItems = MutableStateFlow(todoItemRepository.getAllTodos())
}