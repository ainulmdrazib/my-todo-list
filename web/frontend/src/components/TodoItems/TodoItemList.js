import TodoItem from "./TodoItem";

function TodoItemList(props){
    
    return (
      <div className="todo-list-box">
        <h1><em>Tasks to do</em></h1>

        <div className="todo-list">
            { props.todo_items_data && props.todo_items_data.length > 0 
            ? (props.todo_items_data.map((todo_item_data, i) => {
            return (<TodoItem key={i} delete_todo={props.delete_todo} todo_data={todo_item_data} />)
            })) 
            : <div>No more tasks to do. Congrats! </div>}
        </div>
      </div>
    );
  }
  
  export default TodoItemList;