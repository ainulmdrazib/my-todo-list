package com.ainulmdrazibtw.mytodolist.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun TodoList() {

//        val todoFormViewModel by viewModels<TodoFormViewModel>()
    val todoItemListViewModel by remember { mutableStateOf(TodoItemListViewModel()) }

    Column(){
        TodoItemList(todoItemListViewModel)
    }

}