package com.ainulmdrazibtw.mytodolist.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ainulmdrazibtw.mytodolist.R
import com.ainulmdrazibtw.mytodolist.entity.TodoItemDetails

@Composable
fun TodoItemList(viewModel: TodoItemListViewModel) {
    val resId = R.drawable.logo512

    val todoItems by viewModel.todoItems.collectAsState()

    Column(
        modifier = Modifier.padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Column {
                Image(
                    painter = painterResource(id = resId),
                    contentDescription = null,
                    modifier = Modifier.testTag(resId.toString())
                )
                Text(
                    text = stringResource(R.string.app_name),
                    textAlign = TextAlign.Center,
                    fontSize = 22.sp,
                    modifier = Modifier.padding(vertical = 8.dp)
                                        .testTag(R.string.app_name.toString())
                )
            }
        }
        Row {
            Column(modifier = Modifier.padding(8.dp)) {
                TodoItemView(todoItems = todoItems)
            }
        }
    }
}

@Composable
fun TodoItemView(todoItems: List<TodoItemDetails>) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.width(300.dp)){
        Column {
            Text(
                text = stringResource(R.string.todo_list_title),
                fontSize = 20.sp,
                modifier = Modifier.padding(16.dp)
                    .testTag(R.string.todo_list_title.toString()))}
    }
    if(todoItems.isEmpty()){
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = stringResource(R.string.empty_list_message),
                fontSize = 16.sp,
                modifier = Modifier.padding(16.dp)
            )
        }
    } else {
        todoItems.forEach {
            Row(verticalAlignment = Alignment.CenterVertically,

            )
            {
                Checkbox(checked = it.completed, onCheckedChange = {})
                Text(
                    text = it.title,
                    fontSize = 16.sp,
                    modifier = Modifier.width(200.dp),
                )
            }
        }

    }

}