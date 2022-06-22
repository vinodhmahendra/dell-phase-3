package com.simplilearn.workshop.services;

import java.util.List;

import com.simplilearn.workshop.model.Todo;
import com.simplilearn.workshop.repository.TodoRepository;
import com.simplilearn.workshop.repository.TodoRepositoryImpl;

public class TodoServiceImpl implements TodoService {
	
	// depends on "todoRepository"
	private TodoRepository todoRepository = new TodoRepositoryImpl();
	
	@Override
	public List<Todo> findAll() {
		return todoRepository.findAll();
	}

	@Override
	public Todo findById(long theId) {
		return todoRepository.findById(theId);
	}
	
	@Override
	public Todo deleteById(long theId) {
		return todoRepository.deleteById(theId);
	}
	
	@Override
	public Todo save (Todo theTodo) {
		return todoRepository.save(theTodo);
	}
}
