import TodoItem from './TodoItem';
import TodoMaps from '../../constants/maps';

import {shallow, mount} from 'enzyme';

describe('TodoItem', () => {

  const todo_item_data = TodoMaps.SINGLE_TODO;

  it('renders title and checkbox', () => {
      const wrapper = shallow(<TodoItem todo_data={todo_item_data} />);
      
      expect(wrapper.text()).toContain(todo_item_data.title);
      expect(wrapper.find(".todo-checked").length).toBe(1);
      expect(wrapper.find(".todo-delete-button").length).toBe(1);
  });

  // it('toggles todo', () => {
  //     const wrapper = shallow(<TodoItem todo_data={todo_item_data}/>);

  //     // console.log(wrapper.find(".todo-checked").dive().instance())
  //     // const toggleTodo = jest.spyOn(wrapper.instance(), "handleChange")

  //     // wrapper.instance().forceUpdate();

  //     const checkbox = wrapper.find(".todo-checked");

  //     expect(checkbox.props().checked).toBe(false);

  //     // checkbox.simulate('change', { target: { checked: true } });
  //     checkbox.click()
  //     wrapper.update();

  //     expect(checkbox.props().checked).toBe(true); 
  //     expect(toggleTodo).toBeCalled();
    // });

  // TODO: delete todo?

})