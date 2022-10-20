import './TodoForm.css'

import { useState } from "react";

import TodoStrings from "../../constants/strings"
import TodoApiHelper from '../api/TodoApiHelper';


function TodoForm(props){

  const [todoTitle, setTodoTitle] = useState("");
  const [titleError, setTitleError] = useState(false);

  const handleSubmit = async (event) => {
    event.preventDefault();

    if (todoTitle !== ""){
      const todoDetails = {
        "username":props.username,
        "title": todoTitle,
        "completed": false
      }

      setTitleError(false);
      const createdTodo = await TodoApiHelper.createTodo(todoDetails)
      props.update_todos([...props.curr_todos, createdTodo]);
      
      setTodoTitle("")
    } else {
      setTitleError(true);
    }
  };

  return (
    <div className="todo-form">
        <form onSubmit={handleSubmit}>
            <label className="title-label">
              <strong>{TodoStrings.FORM_TITLE}</strong>
            </label>
            <input className="title-field" type="text" placeholder="Title of todo" value={todoTitle}
            onChange={event => setTodoTitle(event.target.value)}/>

            <button className="createButton" type="submit">{TodoStrings.FORM_BUTTON}</button>
            <span className="title-error"><em>{titleError ? TodoStrings.ERROR_TITLE_IS_EMPTY : ""}</em></span>
        </form>
    </div>
  );
}

export default TodoForm;