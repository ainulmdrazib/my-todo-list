package com.ainulmdrazibtw.mytodolist

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.ainulmdrazibtw.mytodolist.view.TodoItemListViewModel
import com.ainulmdrazibtw.mytodolist.view.TodoItemList
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
        composeTestRule.setContent { TodoItemList(testViewModel) }
        composeTestRule.waitForIdle()
    }

    @After
    fun tearDown() {}

    @Test
    fun shouldDisplayAllComponents() {
        composeTestRule.onNodeWithTag(R.string.app_name.toString()).assertIsDisplayed()
        composeTestRule.onNodeWithTag(R.drawable.logo512.toString())
            .assertIsDisplayed()

        composeTestRule.onNodeWithTag(R.string.todo_list_title.toString()).assertIsDisplayed()
    }

    @Test
    fun shouldDisplayAllItemsGivenMultipleTodos() {
        composeTestRule.onNodeWithText("Test todo 1").assertIsDisplayed()
        composeTestRule.onNodeWithText("Test todo 2").assertIsDisplayed()
        composeTestRule.onNodeWithText("Test todo 3").assertIsDisplayed()
    }

    @Test
    fun shouldDisplaySuccessMessageNoTodos() {
        composeTestRule.onNodeWithTag(R.string.app_name.toString()).assertIsDisplayed()
    }

}