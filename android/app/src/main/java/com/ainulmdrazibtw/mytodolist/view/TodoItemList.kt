package com.ainulmdrazibtw.mytodolist.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ainulmdrazibtw.mytodolist.R

@Composable
fun TodoItemList(viewModel: TodoItemListViewModel) {
    var todoItems = viewModel.retrieveTodoInit()

    Column(
        modifier = Modifier.padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Column(modifier = Modifier.padding(8.dp)) {
                Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.width(300.dp)) {
                    Column {
                        Text(
                            text = stringResource(R.string.todo_list_title),
                            fontSize = 20.sp,
                            modifier = Modifier.padding(16.dp)
                                .testTag(R.string.todo_list_title.toString())
                        )
                    }
                }
                TodoItemView(todoItems = todoItems)
            }
        }
    }
}