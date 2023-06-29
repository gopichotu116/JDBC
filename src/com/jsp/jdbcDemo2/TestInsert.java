package com.jsp.jdbcDemo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/m10_e3?user=root&password=root";
			Connection conn = DriverManager.getConnection(url);
			String query="INSERT into student values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, 106);
			ps.setString(2, "Singh");
			ps.setString(3, "singh@gmail.com");
			ps.setString(4, "Java");
			ps.addBatch();
			
			ps.setInt(1, 107);
			ps.setString(2, "Dhoni");
			ps.setString(3, "dhoni@gmail.com");
			ps.setString(4, "Java");
			ps.addBatch();
			
			ps.setInt(1, 108);
			ps.setString(2, "Rohith");
			ps.setString(3, "rohith@gmail.com");
			ps.setString(4, "Python");
			ps.addBatch();
			
			ps.setInt(1, 109);
			ps.setString(2, "Kohli");
			ps.setString(3, "king@gmail.com");
			ps.setString(4, "Mern");
			ps.addBatch();
			
			int[] batch = ps.executeBatch();
			for(int n:batch) {
				System.out.println(n);
			}
			System.out.println(batch.length+" rows of data is inserted");
			conn.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
