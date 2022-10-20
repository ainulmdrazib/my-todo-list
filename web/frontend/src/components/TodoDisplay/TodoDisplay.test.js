import React from 'react';
import { shallow } from 'enzyme';

import TodoItemList from '../TodoItems/TodoItemList';
import TodoDisplay from './TodoDisplay';
import TodoForm from '../TodoForm/TodoForm';

describe('TodoDisplay', () => {
  it('should render components', () => {
    const wrapper = shallow(<TodoDisplay />);
  
    expect(wrapper.text()).toBeTruthy();
    expect(wrapper.find(TodoItemList)).toBeTruthy();
    expect(wrapper.find(TodoForm)).toBeTruthy();
  });
});