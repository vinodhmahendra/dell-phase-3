package com.simplilearn.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.workshop.model.Todo;
import com.simplilearn.workshop.repository.TodoRepository;

@Service(value = "todoService")
public class TodoServiceImpl implements TodoService {
	
	// depends on "todoRepository"
//	private TodoRepository todoRepository = new TodoRepositoryImpl(); // BUG
	
	@Autowired
	private TodoRepository todoRepository;
	
	public void setTodoRepository(TodoRepository todoRepository) {
		System.out.println("Spring Called Setter Method---->");
		this.todoRepository = todoRepository;
	}
	
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
