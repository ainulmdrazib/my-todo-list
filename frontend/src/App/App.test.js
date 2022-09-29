import React from 'react';
import { shallow } from 'enzyme';

import App from './App';
import TodoItemList from '../components/TodoItems/TodoItemList';


// test('renders learn react link', () => {
//   const wrapper = shallow(<App />);
//   const linkElement = screen.getByText(/welcome/i);
//   expect(linkElement).toBeInTheDocument();
// });

describe('App', () => {
  it('should render components', () => {
    const wrapper = shallow(<App />);
  
    expect(wrapper.find(TodoItemList)).toBeTruthy();
  });
});