import './TodoDisplay.css';

import TodoItemList from '../TodoItems/TodoItemList';
import TodoForm from '../TodoForm/TodoForm';
import TodoStrings from '../../constants/strings';
import logo from '../../todoitems_logo.png';
import { useEffect, useState } from 'react';
import TodoApiHelper from '../api/TodoApiHelper';


function TodoDisplay() {
  const [todoItems, setTodoItems] = useState([])

  const errors = {
    titleIsEmpty:""
  }

  const username = TodoStrings.DEFAULT_USERNAME;

  useEffect(() => {
    const getAllTodos = async() => {
      const allTodos = await TodoApiHelper.getAllTodos();
      if (allTodos) {
      setTodoItems(allTodos)

      } else {
        console.log("Unable to get todos.")
      }
    }

    getAllTodos();
  }, [])

  return (
    <div className="todo-display">
      <header className="todo-header">
        <img src={logo} className="todo-logo" alt="logo" />
        <p>
          Welcome back {username}!
        </p>
      </header>
      <TodoForm username={username}
                errors={errors}
                update_todos={setTodoItems}
                curr_todos={todoItems}/>

      <TodoItemList todo_items_data={todoItems}/>
    </div>
  );
}

export default TodoDisplay;
