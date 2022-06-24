package com.simplilearn.workshop.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

	public static Connection getConnection () throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/studentdb?useSSL=false";
		String user = "root";
		String password = "OmgPassword!";
		Connection connection = DriverManager.getConnection(url, user, password);
		return  connection;
	}
}
