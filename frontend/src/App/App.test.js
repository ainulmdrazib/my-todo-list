import React from 'react';
import { shallow } from 'enzyme';

import App from './App';
import TodoItemList from '../components/TodoItems/TodoItemList';
import TodoForm from '../components/TodoForm/TodoForm';


// test('renders learn react link', () => {
//   const wrapper = shallow(<App />);
//   const linkElement = screen.getByText(/welcome/i);
//   expect(linkElement).toBeInTheDocument();
// });

describe('App', () => {
  it('should render components', () => {
    const wrapper = shallow(<App />);
  
    expect(wrapper.text()).toBeTruthy();
    expect(wrapper.find(TodoItemList)).toBeTruthy();
    expect(wrapper.find(TodoForm)).toBeTruthy();
  });
});