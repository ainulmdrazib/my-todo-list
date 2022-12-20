package com.ainulmdrazibtw.mytodolist.view

import androidx.lifecycle.ViewModel
import com.ainulmdrazibtw.mytodolist.repository.TodoItemRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow

class TodoItemListViewModel(
) : ViewModel() {
    private val todoItemRepository = TodoItemRepositoryImpl()
    var todoItems = MutableStateFlow(todoItemRepository.getAllTodos())
}