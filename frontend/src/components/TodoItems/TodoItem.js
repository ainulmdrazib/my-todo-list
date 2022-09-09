import './TodoItem.css'

function TodoItem(props){
  return (
    <div className="todo-item-box">
        <div className="completed-box">
            <input id="todo-checked" type="checkbox" defaultChecked={false} />
        </div>
        <div className="todo-title-box">{props.todo_data.title}</div>
    </div>
  );
}

export default TodoItem;