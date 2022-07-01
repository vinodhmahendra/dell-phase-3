package simplilearn.services;

import java.util.List;

import simplilearn.model.Todo;



public interface TodoService {

	List<Todo> findAll();

	Todo findById(long theId);

	Todo deleteById(long theId);

	Todo save(Todo theTodo);
	
	void updateTodo(long id,Todo theTodo);

}