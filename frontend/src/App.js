import logo from './app-logo-200.png';
import './App.css';
import TodoItemList from './components/TodoItems/TodoItemList';

const todo_items_data = [
    {
        "completed": false,
        "title": "Todo Item 1"
    },{
        "completed": false,
        "title": "Todo Item 2"
    },{
        "completed": false,
        "title": "Todo Item 3"
    }
]

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <h1>
          Kick your tasks goodbye!
        </h1>
      </header>
      <TodoItemList todo_items_data={todo_items_data} />
    </div>
  );
}

export default App;
