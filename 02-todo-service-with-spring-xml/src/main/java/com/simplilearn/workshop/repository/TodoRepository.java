package com.simplilearn.workshop.repository;

import java.util.List;

import com.simplilearn.workshop.model.Todo;

public interface TodoRepository {

	Todo save(Todo theTodo);

	Todo deleteById(long theId);

	List<Todo> findAll();

	Todo findById(long theId);

}