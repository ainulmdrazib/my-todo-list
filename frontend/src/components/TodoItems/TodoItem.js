import { useState } from 'react';
import './TodoItem.css'
import TrashIcon from '../../TrashIcon'
import TodoApiHelper from '../api/TodoApiHelper';

function TodoItem(props){

  const [isChecked, setIsChecked] = useState(props.todo_data.completed);  

  const handleChange = async() => {

    const toggledTodo = await TodoApiHelper.toggleTodo(props.todo_data)
    setIsChecked(!isChecked)

    console.log("toggled todo with title: " + toggledTodo.title)

  }

  const handleClick = async() => {
    props.delete_todo(props.todo_data)

    console.log("delete button clicked")
  }

  return (
    <div className="todo-item-box">
        <div className="completed-box">
            <input className="todo-checked" type="checkbox" onChange={handleChange} checked={isChecked} />
        </div>
        <div className="todo-title-box">{props.todo_data.title}</div>
        <div className="todo-delete-container">
          <button className="todo-delete-button" onClick={handleClick}>
            <TrashIcon/>
          </button>
        </div>
    </div>
  ); 
}

export default TodoItem;