import axios from 'axios'

const API_URL = "http://localhost:8080"

// async function createTodo(todoDetails) {
//     const {data: createdTodo} = await axios

// }

async function getAllTodos() {
    try {
        const {data: allTodos} = await axios.get("/allTodos", {baseURL: API_URL})
        return allTodos;
    } catch (error){
        console.error("Error: ", error)
        return null;
    }
}

export default {getAllTodos}