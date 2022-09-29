import React from 'react';
import { shallow } from 'enzyme';

import TodoItemList from './TodoItemList';
import TodoItem from './TodoItem';


describe('TodoItemList', () => {


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

