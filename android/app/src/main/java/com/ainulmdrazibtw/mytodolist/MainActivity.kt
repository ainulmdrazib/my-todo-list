package com.ainulmdrazibtw.mytodolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import com.ainulmdrazibtw.mytodolist.ui.theme.MyTodoListTheme
import com.ainulmdrazibtw.mytodolist.view.TodoItemListViewModel
import com.ainulmdrazibtw.mytodolist.view.TodoItemList
import com.ainulmdrazibtw.mytodolist.view.TodoList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyTodoListTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier.fillMaxSize()
                ) {
TodoList()
                }
            }
        }
    }
}
