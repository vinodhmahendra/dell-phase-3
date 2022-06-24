package com.simplilearn.workshop.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.simplilearn.workshop.model.Todo;

@Repository(value = "todoRepository")
public class TodoRepositoryImpl implements TodoRepository {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public TodoRepositoryImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public final RowMapper<Todo> toRowMapper = (rs, rowNum) -> {
		Todo theTodo = new Todo(rs.getLong("id"), rs.getString("username"), rs.getString("description"),
				rs.getDate("target_date"), rs.getBoolean("is_done"));
		return theTodo;
	};

	@Override
	public List<Todo> findAll() {
		List<Todo> todos = this.jdbcTemplate.query("select * from todos", toRowMapper);
		return todos;
	}

	@Override
	public Todo save(Todo theTodo) {

		this.jdbcTemplate.update(
				"insert into todos (username,description,target_date,is_done) values ('"
				+theTodo.getUsername()+"','"+theTodo.getDescription()+"',current_timestamp(),false)");
		return null;
	}

	@Override
	public Todo deleteById(long theId) {
		this.jdbcTemplate.update("delete from todos where id = ?", Long.valueOf(theId));
		return null;
	}

	@Override
	public Todo findById(long theId) {
		String sql = "select * from todos where id=?";
		Todo theTodo = jdbcTemplate.queryForObject(sql, toRowMapper, theId);
		return theTodo;
	}

}
