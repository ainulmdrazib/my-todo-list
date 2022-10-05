import TodoItem from './TodoItem';
import TodoMaps from '../../constants/maps';

import {shallow} from 'enzyme';

describe('TodoItem', () => {

  const todo_item_data = TodoMaps.SINGLE_TODO;

  it('renders title and checkbox', () => {
      const wrapper = shallow(<TodoItem todo_data={todo_item_data} />);
      
      expect(wrapper.text()).toContain(todo_item_data.title);
      expect(wrapper.find(".todo-checked").length).toBe(1);
  });

  it('toggles todo', () => {
      const toggleTodo = jest.fn()
      const wrapper = shallow(<TodoItem todo_data={todo_item_data} toggleTodo={toggleTodo}/>);

      const checkbox = wrapper.find(".todo-checked");

      expect(checkbox.props().checked).toBe(false);

      checkbox.simulate('change', { target: { checked: true } });
      wrapper.update();

      expect(toggleTodo).toBeCalled();
  });

})