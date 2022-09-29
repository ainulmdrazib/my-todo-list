import TodoItemList from '../components/TodoItems/TodoItemList';
import logo from '../todoitems_logo.png';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Welcome back!
        </p>
      </header>
        <TodoItemList />
    </div>
  );
}

export default App;
