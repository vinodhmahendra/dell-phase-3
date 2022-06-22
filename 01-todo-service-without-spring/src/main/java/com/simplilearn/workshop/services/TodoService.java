package com.simplilearn.workshop.services;

import java.util.List;

import com.simplilearn.workshop.model.Todo;

public interface TodoService {

	List<Todo> findAll();

	Todo findById(long theId);

	Todo deleteById(long theId);

	Todo save(Todo theTodo);

}