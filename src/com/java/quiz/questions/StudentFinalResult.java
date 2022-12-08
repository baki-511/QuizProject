package com.java.quiz.questions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentFinalResult {
	public void getLogic() {

		try {
			ConnectionTest connectiontest = new ConnectionTest();
			Connection con = connectiontest.getQuestions();
			PreparedStatement ppp;
			ppp = con.prepareStatement("select * from JavaQuestion");
			ResultSet rs = ppp.executeQuery();
			while (rs.next()) {
				if (rs.getInt(7) == rs.getInt(8)) {
					PreparedStatement ppa = con.prepareStatement("insert into JavaQuestion(marks) values (1)");
					ppa.execute();

				} else {
					PreparedStatement ppa = con.prepareStatement("insert into JavaQuestion(marks) values (0)");
					ppa.execute();
				}
			}
			System.out.println("Successfully Done ");
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}
