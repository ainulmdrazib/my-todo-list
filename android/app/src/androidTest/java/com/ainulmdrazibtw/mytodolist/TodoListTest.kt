package com.ainulmdrazibtw.mytodolist

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.ainulmdrazibtw.mytodolist.repository.TodoItemRepositoryImpl
import com.ainulmdrazibtw.mytodolist.view.TodoItemListViewModel
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TodoListTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val testViewModel = TodoItemListViewModel()

    @Before
    fun setUp() {
        composeTestRule.setContent { TodoList(testViewModel) }
        composeTestRule.waitForIdle()
    }

    @After
    fun tearDown() {}

    @Test
    fun shouldDisplayAllComponents() {
        composeTestRule.onNodeWithText("My Todo List").assertIsDisplayed()
        composeTestRule.onNodeWithTag(R.drawable.logo512.toString())
            .assertIsDisplayed()    }

    @Test
    fun shouldDisplayAllItemsGivenMultipleTodos() {
        composeTestRule.onNodeWithText("Test todo 1").assertIsDisplayed()
        composeTestRule.onNodeWithText("Test todo 2").assertIsDisplayed()
        composeTestRule.onNodeWithText("Test todo 3").assertIsDisplayed()
    }
}