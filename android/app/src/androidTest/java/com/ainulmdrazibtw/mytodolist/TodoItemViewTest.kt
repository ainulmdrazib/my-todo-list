package com.ainulmdrazibtw.mytodolist

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.ainulmdrazibtw.mytodolist.entity.TodoItemDetails
import com.ainulmdrazibtw.mytodolist.ui.theme.MyTodoListTheme
import com.ainulmdrazibtw.mytodolist.view.TodoItemView
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TodoItemTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private var todoItems = listOf(TodoItemDetails("testing", false, "user123"))

    private fun isToggleableWithSiblingText(todoTitle: String): SemanticsMatcher =
        hasAnySibling(hasText(todoTitle)) and isToggleable()

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {}


    @Test
    fun shouldDisplayAndToggleTodo() {
        composeTestRule.setContent { MyTodoListTheme {
            TodoItemView(todoItems = todoItems)

        } }
        composeTestRule.waitForIdle()

        composeTestRule.onNode(isToggleableWithSiblingText("testing")).performClick()
        composeTestRule.onNode(isToggleableWithSiblingText("testing")).assertIsOn()
        composeTestRule.onNode(isToggleableWithSiblingText("testing")).performClick()
        composeTestRule.onNode(isToggleableWithSiblingText("testing")).assertIsOff()

    }

    @Test
    fun shouldDisplayNoTodoMessageGivenEmptyList() {
        composeTestRule.setContent { MyTodoListTheme {
            TodoItemView(todoItems = emptyList())

        } }
        composeTestRule.waitForIdle()

        composeTestRule.onNodeWithTag(R.string.empty_list_message.toString()).assertIsDisplayed()

    }

}