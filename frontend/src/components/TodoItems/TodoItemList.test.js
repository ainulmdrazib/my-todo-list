import React from 'react';
import { shallow } from 'enzyme';

import TodoItemList from './TodoItemList';
import TodoItem from './TodoItem';
import TodoMaps from '../../constants/maps'


describe('TodoItemList', () => {

    const todo_items_data = TodoMaps.MULTIPLE_TODOS;

    it('renders multiple items', () => {
        const wrapper = shallow(<TodoItemList todo_items_data={todo_items_data} />);
        
        expect(wrapper.find(TodoItem).length).toBe(3);
        });

    it('renders an empty list', () => {
        const wrapper = shallow(<TodoItemList todo_items_data={[]} />);
        
        expect(wrapper.find(TodoItem).length).toBe(0);
        expect(wrapper.text().includes('No more tasks')).toBe(true);
        });
})

