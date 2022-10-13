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

const api_methods = {getAllTodos, createTodo}
export default api_methods