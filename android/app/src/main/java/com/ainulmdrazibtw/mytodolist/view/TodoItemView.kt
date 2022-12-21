package com.ainulmdrazibtw.mytodolist.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ainulmdrazibtw.mytodolist.R
import com.ainulmdrazibtw.mytodolist.entity.TodoItemDetails

@Composable
fun TodoItemView(todoItems: List<TodoItemDetails>) {
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
    if(todoItems.isEmpty()){
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = stringResource(R.string.empty_list_message),
                fontSize = 16.sp,
                modifier = Modifier.padding(16.dp).testTag(R.string.empty_list_message.toString())
            )
        }
    } else {
        todoItems.forEach {
            Row(
                verticalAlignment = Alignment.CenterVertically,

                )
            {
                val isTodoComplete = remember { mutableStateOf(it.completed) }
                Checkbox(checked = isTodoComplete.value, onCheckedChange = {isTodoComplete.value = it})
                Text(
                    text = it.title,
                    fontSize = 16.sp,
                    modifier = Modifier.width(200.dp),
                    textDecoration =
                        if (isTodoComplete.value) {
                            TextDecoration.LineThrough
                        } else {
                            TextDecoration.None
                        }
                )
            }
        }

    }

}