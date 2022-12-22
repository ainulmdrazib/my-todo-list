package com.ainulmdrazibtw.mytodolist

import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.ainulmdrazibtw.mytodolist.entity.TodoItemDetails
import com.ainulmdrazibtw.mytodolist.repository.TodoItemRepositoryImpl
import com.ainulmdrazibtw.mytodolist.view.TodoForm
import com.ainulmdrazibtw.mytodolist.view.TodoFormViewModel
import com.ainulmdrazibtw.mytodolist.view.TodoItemListViewModel
import com.ainulmdrazibtw.mytodolist.view.TodoItemList
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class TodoFormTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val testViewModel = TodoItemListViewModel()

    var titleError = ""
    @Before
    fun setUp() {
        composeTestRule.setContent {
            titleError = stringResource(R.string.todo_form_title_error)
            TodoForm(testViewModel) }
        composeTestRule.waitForIdle()
    }

    @After
    fun tearDown() {}

    @Test
    fun shouldDisplayAllComponents() {
        composeTestRule.onNodeWithTag(R.string.todo_form_textfield.toString()).assertIsDisplayed()
        composeTestRule.onNodeWithTag(R.string.todo_form_button_title.toString())
            .assertIsDisplayed()
    }

    @Test
    fun shouldCreateTodoGivenValidTitle() {
        composeTestRule.onNodeWithTag(R.string.todo_form_textfield.toString()).performTextInput("todo test")
        composeTestRule.onNodeWithTag(R.string.todo_form_button_title.toString()).performClick()
        composeTestRule.onNodeWithText(titleError).assertDoesNotExist()
    }
    @Test
    fun shouldRejectInvalidTitle() {
        composeTestRule.onNodeWithTag(R.string.todo_form_textfield.toString()).performTextInput("")
        composeTestRule.onNodeWithTag(R.string.todo_form_button_title.toString()).performClick()
        composeTestRule.onNodeWithText(titleError).assertExists()
    }

//    @Test
//    fun shouldDisplaySuccessMessageNoTodos() {
//        val mockTodoItemRepository = mock(TodoItemRepositoryImpl::class.java)
//        `when`(mockTodoItemRepository.getAllTodos()).thenReturn(emptyList())
//
//        composeTestRule.onNodeWithTag(R.string.empty_list_message.toString()).assertIsDisplayed()
//    }

}