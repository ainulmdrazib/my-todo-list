import axios from 'axios'

const API_URL = "http://localhost:8080"

// async function createTodo(todoDetails) {
//     const {data: createdTodo} = await axios

// }

async function getAllTodos() {
    try {
        const {data: allTodos} = await axios({method:"get",
                                            url:"/allTodos", 
                                            baseURL: API_URL})
        return allTodos;
    } catch (error){
        console.error("Error: ", error)
        return null;
    }
}

async function createTodo(todoDetails) {
    try {
        const {data: createdTodo} = await axios({method:"post",
                                                  url:"/createTodo",
                                                  baseURL: API_URL, 
                                                data: todoDetails});
        return createdTodo;
    } catch (error){
        console.error("Error: ", error)
        return null;
    }
}

async function toggleTodo(todoDetails) {
    try {
        const {data: toggledTodo} = await axios({method:"post",
                                                  url:"/toggleTodo",
                                                  baseURL: API_URL, 
                                                data: todoDetails});
        return toggledTodo;
    } catch (error){
        console.error("Error: ", error)
        return null;
    }
}

async function deleteTodo(todoDetails) {
    try {
        const {data: deletedTodoMsg} = await axios({method:"post",
                                                  url:"/deleteTodo",
                                                  baseURL: API_URL, 
                                                data: todoDetails});
        return deletedTodoMsg;
    } catch (error){
        console.error("Error: ", error)
        return null;
    }
}

const api_methods = {getAllTodos, createTodo, toggleTodo, deleteTodo}
export default api_methods