package com.ainulmdrazibtw.mytodolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ainulmdrazibtw.mytodolist.entity.TodoItemDetails
import com.ainulmdrazibtw.mytodolist.ui.theme.MyTodoListTheme
import com.ainulmdrazibtw.mytodolist.view.TodoItemListViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val todoItemViewModel by viewModels<TodoItemListViewModel>()
        println("TODODODODOD" + todoItemViewModel.todoItems.toString())

        setContent {
            MyTodoListTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TodoList(todoItemViewModel)
                }
            }
        }
    }
}

@Composable
fun TodoList(viewModel: TodoItemListViewModel) {
    val resId = R.drawable.logo512

    val todoItems by viewModel.todoItems.collectAsState()

    Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Column{
                Image(painter = painterResource(id = resId),
                    contentDescription = null,
                    Modifier.testTag(resId.toString()))
                Text(text = "My Todo List", fontSize = 22.sp,
                    modifier = Modifier.padding(vertical = 8.dp))
            }
        }
        Row {
            Column(modifier = Modifier.padding(16.dp)) {
                TodoItemView(todoItems = todoItems)
            }
        }
    }



}


@Composable
fun TodoItemView(todoItems: List<TodoItemDetails>){
    todoItems.forEach{
        Row(verticalAlignment = Alignment.CenterVertically)  {
            Checkbox(checked = it.completed, onCheckedChange = {})
            Text(text = it.title,
                fontSize = 16.sp,
                modifier = Modifier.padding(16.dp))
        }
    }

}