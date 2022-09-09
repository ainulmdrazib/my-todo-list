import { render, screen } from '@testing-library/react';
import TodoItem from './TodoItem';

const todo_item_data = {
    "completed": false,
    "title": "Todo Item 1"
}

test('renders item', () => {
  render(<TodoItem todo_data={todo_item_data} />);
  const todo_title = screen.getByText(/todo item 1/i);
  expect(todo_title).toBeInTheDocument();
});
