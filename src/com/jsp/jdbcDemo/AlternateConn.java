package com.jsp.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AlternateConn {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// query String -> add data in the form of key and values 
			String url="jdbc:mysql://localhost:3306/m10_e3?user=root&password=root";
			
			Connection conn = DriverManager.getConnection(url);

			System.out.println("connected");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
