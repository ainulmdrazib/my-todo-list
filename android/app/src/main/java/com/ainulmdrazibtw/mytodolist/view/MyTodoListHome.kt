package com.ainulmdrazibtw.mytodolist.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun MyTodoListHome() {

    val todoItemListViewModel by remember { mutableStateOf(TodoItemListViewModel()) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TodoAppHeader()
        TodoForm(todoItemListViewModel)
        TodoItemList(todoItemListViewModel)
    }

}