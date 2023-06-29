package com.jsp.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class AlternateConn2 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/m10_e3";
			Properties pro = new Properties();
			pro.setProperty("user", "root");
			pro.setProperty("password", "root");
			
			Connection conn = DriverManager.getConnection(url, pro);
			System.out.println("Connected");
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
