package com.simplilearn.workshop.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.simplilearn.workshop.model.Todo;
import com.simplilearn.workshop.utils.ConnectionUtils;

@Repository(value = "todoRepository")
public class TodoRepositoryImpl implements TodoRepository {


	@Override
	public List<Todo> findAll() {
		List<Todo> todos = new ArrayList<>();
		try (Connection connection = ConnectionUtils.getConnection();
				Statement statement = connection.createStatement()) {
			String sql = "select * from todos";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Todo theTodo = new Todo(rs.getLong("id"), rs.getString("username"), rs.getString("description"),
						rs.getDate("target_date"), rs.getBoolean("is_done"));

				todos.add(theTodo);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return todos;
	}

	@Override
	public Todo save(Todo theTodo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Todo deleteById(long theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Todo findById(long theId) {
		Todo theTodo = null;
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement("select * from todos where id=?")) {
			statement.setLong(1, theId);
			ResultSet rs = statement.executeQuery();
			
			if (rs.next()) {
				 theTodo = new Todo(rs.getLong("id"), rs.getString("username"), rs.getString("description"),
						rs.getDate("target_date"), rs.getBoolean("is_done"));
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return theTodo;
	}


}
