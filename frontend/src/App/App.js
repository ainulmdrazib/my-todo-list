import TodoItemList from '../components/TodoItems/TodoItemList';
import TodoForm from '../components/TodoForm/TodoForm';
import TodoMaps from '../constants/maps';
import TodoStrings from '../constants/strings';
import logo from '../todoitems_logo.png';
import './App.css';
import { useEffect } from 'react';

function App() {
  const todo_items_data = TodoMaps.MULTIPLE_TODOS;

  const errors = {
    titleIsEmpty:""
  }

  const username = TodoStrings.DEFAULT_USERNAME;

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Welcome back {username}!
        </p>
      </header>
      <TodoForm errors={errors} />
      <TodoItemList todo_items_data={todo_items_data}/>
    </div>
  );
}

export default App;
