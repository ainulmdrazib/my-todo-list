import React from 'react';
import { mount } from 'enzyme';

import TodoForm from './TodoForm';
import TodoStrings from "../../constants/strings"


describe('TodoForm', () => {

    const testPropErrors = {
        "titleIsEmpty":""
    }

    const mockCreateTodo = jest.fn()

    it('renders form components', () => {
        const wrapper = mount(<TodoForm  errors={testPropErrors}/>);

        expect(wrapper.find('.createButton').length).toBe(1);
        expect(wrapper.find('.title-field').length).toBe(1);
        expect(wrapper.find('.title-error').length).toBe(1);
    })

    it('submits title', () => {
        const wrapper = mount(<TodoForm createTodo={mockCreateTodo} />);

        const createButton = wrapper.find('.createButton');
        const titleField = wrapper.find('.title-field');
        const titleError = wrapper.find('.title-error');

        titleField.simulate('change', { target: { value: 'todo item 1' } })

        createButton.simulate("submit");

        // expect(mockCreateTodo).toBeCalledTimes(1);
        expect(titleError.text()).toBe("");

    });

    it('rejects empty title and displays error message', () => {
        const wrapper = mount(<TodoForm createTodo={mockCreateTodo}/>);

        const createButton = wrapper.find('.createButton');
        const titleError = wrapper.find('.title-error');

        createButton.simulate("submit");

        expect(titleError.text()).toBe(TodoStrings.ERROR_TITLE_IS_EMPTY);
    });
})

