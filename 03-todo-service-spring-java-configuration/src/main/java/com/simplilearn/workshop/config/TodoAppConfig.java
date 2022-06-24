package com.simplilearn.workshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.simplilearn.workshop.repository.TodoRepository;
import com.simplilearn.workshop.repository.TodoRepositoryImpl;
import com.simplilearn.workshop.services.TodoService;
import com.simplilearn.workshop.services.TodoServiceImpl;

@Configuration
public class TodoAppConfig {
	
	@Bean
	public TodoRepository todoRepository() {
		TodoRepositoryImpl todoRepository = new TodoRepositoryImpl();
		return todoRepository;
	}

	
	@Bean
	public TodoService todoService() {
		TodoServiceImpl todoService = new TodoServiceImpl();
//		Setter Dependency  Injection
		todoService.setTodoRepository(todoRepository());
		return todoService;
	}


}
