package simplilearn.repository;

import java.util.List;

import simplilearn.model.Todo;


public interface TodoRepository {

	Todo save(Todo theTodo);

	Todo deleteById(long theId);

	List<Todo> findAll();

	Todo findById(long theId);
	
	void updateTodo(long id,Todo theTodo);

}