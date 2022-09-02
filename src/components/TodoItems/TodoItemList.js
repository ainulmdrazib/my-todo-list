import TodoItem from "./TodoItem";

function TodoItemList(props){
    return (
      <div className="todo-list-box">
        <h1>Tasks to do</h1>

        <div className="todo-list">
            {props.todo_items_data.map((todo_item_data, i) => { 
            // Return the element. Also pass key     
            return (<TodoItem key={i} todo_data={todo_item_data} />) 
            })}
        </div>
      </div>
    );
  }
  
  export default TodoItemList;