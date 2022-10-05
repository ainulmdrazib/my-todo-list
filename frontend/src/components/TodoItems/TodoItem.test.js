import TodoItem from './TodoItem';
import TodoMaps from '../../constants/maps';

import {shallow} from 'enzyme';

describe('TodoItem', () => {

  const todo_item_data = TodoMaps.SINGLE_TODO;

  it('renders title and checkbox', () => {
      const wrapper = shallow(<TodoItem todo_data={todo_item_data} />);
      
      expect(wrapper.text()).toContain(todo_item_data.title);
      expect(wrapper.find("#todo-checked").length).toBe(1);
  });
})