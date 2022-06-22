package com.simplilearn.workshop.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.simplilearn.workshop.model.Todo;

public class TodoRepositoryImpl implements TodoRepository {
	
	@Override
	public Todo save ( Todo theTodo) {
		if ( theTodo.getId() == -1 || theTodo.getId() == 0 ) {
			theTodo.setId(++counter);
			todos.add(theTodo);
		}else {
			deleteById(theTodo.getId());
			todos.add(theTodo);
		}
		return theTodo;
	}
	
	@Override
	public Todo deleteById(long theId) {
		Todo theTodo = findById(theId);
		
		if ( theTodo == null ) {
			return null;
		}
		
		if ( todos.remove(theTodo)) {
			return theTodo;
		}
		
		return null;
		
	}

	private static List<Todo> todos = new ArrayList<>();
	private static int counter = 0;
	
	static {
		todos.add(new Todo(++counter ,"vinodh", "Learn to dance", new Date(), false));
		todos.add(new Todo(++counter ,"vinodh", "Learn to cook", new Date(), false));
		todos.add(new Todo(++counter ,"vinodh", "Learn to skate", new Date(), false));
	}
	
	@Override
	public  List<Todo> findAll() {
		return todos;
	}

	
	@Override
	public Todo findById(long theId) {
		for ( Todo theTodo : todos) {
			if ( theTodo.getId() == theId) {
				return theTodo;
			}
		}
		return null;
	}
}
