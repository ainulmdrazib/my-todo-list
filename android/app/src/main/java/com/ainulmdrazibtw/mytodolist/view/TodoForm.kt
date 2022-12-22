package com.ainulmdrazibtw.mytodolist.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ainulmdrazibtw.mytodolist.R
import com.ainulmdrazibtw.mytodolist.entity.TodoItemDetails

@Composable
fun TodoForm(viewModel: TodoItemListViewModel) {
    var titleValue by remember { mutableStateOf(TextFieldValue("")) }

    var titleError by remember { mutableStateOf(false) }
    
    Column(modifier = Modifier.padding(16.dp)){
        TextField(

            value = titleValue,
            onValueChange = { it ->
                titleValue = it
            },
            singleLine = true,
//            label = { Text(modifier = Modifier.size(22.dp),
//                        text = stringResource(R.string.todo_form_textfield)) },
            placeholder = { Text(text = "Title of new todo")},
            modifier = Modifier.testTag(R.string.todo_form_textfield.toString())
        )
        Text(color = Color.Red, text = if (titleError) {
            stringResource(R.string.todo_form_title_error)
        } else {
            ""
        })
        Button(
            modifier = Modifier.testTag(R.string.todo_form_button_title.toString()),
            onClick = {
                if(titleValue.text.isNotBlank()) {
                    titleError = false
                    val todoToAdd: TodoItemDetails = TodoItemDetails(title = titleValue.text, username = viewModel.DEFAULT_USERNAME)
                    viewModel.addTodo(todoToAdd)
                    println("TITLE VALID: " + todoToAdd.title)
                } else {
                    titleError = true
                }
            },
            // Uses ButtonDefaults.ContentPadding by default
            contentPadding = PaddingValues(
                start = 8.dp,
                top = 4.dp,
                end = 8.dp,
                bottom = 4.dp
            )
        ) {
            Text(
                text = stringResource(R.string.todo_form_button_title),
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(vertical = 8.dp))
        }
    }

}



