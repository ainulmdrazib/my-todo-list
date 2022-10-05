import './TodoDisplay.css';


import TodoItemList from '../TodoItems/TodoItemList';
import TodoForm from '../TodoForm/TodoForm';
import TodoMaps from '../../constants/maps';
import TodoStrings from '../../constants/strings';
import logo from '../../todoitems_logo.png';


function TodoDisplay() {
  const todo_items_data = TodoMaps.MULTIPLE_TODOS;

  const errors = {
    titleIsEmpty:""
  }

  const username = TodoStrings.DEFAULT_USERNAME;

  return (
    <div className="todo-display">
      <header className="todo-header">
        <img src={logo} className="todo-logo" alt="logo" />
        <p>
          Welcome back {username}!
        </p>
      </header>
      <TodoForm username={username} errors={errors} />
      <TodoItemList todo_items_data={todo_items_data}/>
    </div>
  );
}

export default TodoDisplay;
