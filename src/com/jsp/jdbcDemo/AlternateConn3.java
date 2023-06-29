package com.jsp.jdbcDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class AlternateConn3 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/m10_e3";
			
		FileInputStream stream =new FileInputStream("mydbinfo.properties");
		Properties pro = new Properties();
		pro.load(stream);
		Connection conn = DriverManager.getConnection(url, pro);
		System.out.println("connected");
		conn.close();
		} 
		catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
