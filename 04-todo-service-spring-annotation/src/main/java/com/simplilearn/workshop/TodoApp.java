package com.simplilearn.workshop;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.simplilearn.workshop.config.TodoAppConfig;
import com.simplilearn.workshop.model.Todo;
import com.simplilearn.workshop.services.TodoService;

public class TodoApp {

	public static void main(String[] args) {
		
		// spring container
		ApplicationContext context = new AnnotationConfigApplicationContext(TodoAppConfig.class);
		
//		TodoService theTodoService = new TodoServiceImpl();
		
		// retrieve configured instance
		TodoService theTodoService = context.getBean("todoService", TodoService.class);

		List<Todo> todos = theTodoService.findAll();
		
		for ( Todo theTodo: todos) {
			System.out.println(theTodo.getDescription());
		}
	}

}
