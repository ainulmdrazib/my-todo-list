import { useState } from 'react';
import './TodoItem.css'

function TodoItem(props){

  const [isChecked, setIsChecked] = useState(props.todo_data.completed);  

  function handleChange(){

    setIsChecked(!isChecked)
    props.toggleTodo(props.todo_data.id, isChecked)

  }

  return (
    <div className="todo-item-box">
        <div className="completed-box">
            <input className="todo-checked" type="checkbox" onChange={handleChange} checked={isChecked} />
        </div>
        <div className="todo-title-box">{props.todo_data.title}</div>
    </div>
  ); 
}

export default TodoItem;