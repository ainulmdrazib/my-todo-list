import './TodoItem.css'

function TodoItem(props){
  return (
    <div className="todo-item-box">
        <div className="completed-box">
            <input className="todo-checked" type="checkbox" checked={props.todo_data.completed} />
        </div>
        <div className="todo-title-box">{props.todo_data.title}</div>
    </div>
  ); 
}

export default TodoItem;