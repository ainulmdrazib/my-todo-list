import { render, screen } from '@testing-library/react';
import TodoItemList from './TodoItemList';

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

test('renders multiple items', () => {
  render(<TodoItemList todo_items_data={todo_items_data} />);
  const todo_items = screen.getAllByText(/todo item/i);
  expect(todo_items).toHaveLength(3);
});