package com.java.quiz.questions;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {
	Connection connection = null;

	public Connection getQuestions() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Quiz", "root", "Justdoit@0405");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
}
