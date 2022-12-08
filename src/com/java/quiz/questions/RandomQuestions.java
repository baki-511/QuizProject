package com.java.quiz.questions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class RandomQuestions {
	public void userDetails() {

		Scanner scan = new Scanner(System.in);
		HashSet<Integer> javaSet = new HashSet<Integer>();

		ArrayList<Integer> rowChoice = new ArrayList<Integer>();

		ConnectionTest connectiontest = new ConnectionTest();
		Connection con = connectiontest.getQuestions();
		try {
			PreparedStatement pst = con.prepareStatement("select * from JavaQuestion");
			ResultSet rs = pst.executeQuery();
//			for(int row :javaSet) {
//				
//				
//			}
			Iterator<Integer> itr = javaSet.iterator();
			for (int i : javaSet) {
				System.out.println(i);
			}
			javaSet.add(1);
			javaSet.add(2);
			javaSet.add(3);
			// int row = 3;
			while (rs.next()) {
				System.out.println(rs.getInt(1) + ") " + rs.getString(2) + "\nA." + rs.getString(3) + "\tB."
						+ rs.getString(4) + "\tC." + rs.getString(5) + "\tD." + rs.getString(6));
				System.out.println();
				System.out.print("Enter your choice : ");
				int choice = scan.nextInt();
				// "update programmer set Programmer_name = ?, programmer_city = ? " + "where
				// programmer_id = ?"

				int m = 1;
				PreparedStatement studentChoice = con
						.prepareStatement("update JavaQuestion set student_answer = ? where question_id =? ");
				studentChoice.setInt(1, choice);
				studentChoice.setInt(2, m);
				m++;
//				rowChoice.add(1);
//				rowChoice.add(2);
//				rowChoice.add(3);
//				for (int m : rowChoice) {
//					studentChoice.setInt(2, m);
//				}

				studentChoice.execute();
				System.out.println();
			}

			pst.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		RandomQuestions random = new RandomQuestions();
		random.userDetails();
		//StudentFinalResult sfr = new StudentFinalResult();
		//sfr.getLogic();

	}

}
