package com.jsp.dynamicCrudOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestMultiInsert {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/m10_e3";
			String user="root";
			String pass="root";
			Connection conn = DriverManager.getConnection(url,user,pass);
			
			String query="insert into student1 values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1,101);
			ps.setString(2, "PK");
			ps.setString(3, "pk113@gmail.com");
			ps.setString(4, "java");
			ps.addBatch();
			
			ps.setInt(1,102);
			ps.setString(2, "PK");
			ps.setString(3, "pk11@gmail.com");
			ps.setString(4, "java");
			ps.addBatch();
			
			ps.setInt(1,103);
			ps.setString(2, "PK");
			ps.setString(3, "pk1143@gmail.com");
			ps.setString(4, "java");
			ps.addBatch();
			
			ps.setInt(1,104);
			ps.setString(2, "PK");
			ps.setString(3, "pk1113@gmail.com");
			ps.setString(4, "java");
			ps.addBatch();
			
			ps.setInt(1,105);
			ps.setString(2, "PK");
			ps.setString(3, "pk1135@gmail.com");
			ps.setString(4, "java");
			ps.addBatch();
			
			int[] batch = ps.executeBatch();
			for(int e:batch) {
				System.out.println(e);
			}
			System.out.println(batch.length+" rows of data inserted");
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
