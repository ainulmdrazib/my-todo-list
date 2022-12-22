package com.ainulmdrazibtw.mytodolist

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.ainulmdrazibtw.mytodolist.entity.TodoItemDetails
import com.ainulmdrazibtw.mytodolist.repository.TodoItemRepositoryImpl
import com.ainulmdrazibtw.mytodolist.view.TodoItemListViewModel
import com.ainulmdrazibtw.mytodolist.view.TodoItemList
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class TodoItemListTest {
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
        composeTestRule.onNodeWithTag(R.string.todo_list_title.toString()).assertIsDisplayed()
    }

}