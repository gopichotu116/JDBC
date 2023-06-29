package com.jsp.crudOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSelect3 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/m10_e3";
			String user="root";
			String pass="root";
			
			Connection conn=DriverManager.getConnection(url,user,pass);
			
			Statement stmt = conn.createStatement();
			String query="Select * from student";
			ResultSet rs = stmt.executeQuery(query);
			System.out.println(rs);
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println("-------------------------------------------------");
			}
			/**
			 Q. How to get data from resultset?
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email=rs.getString("email");
				String course=rs.getString("cource");
				System.out.println(id + "  " + name + "  " + email +
						"  " + course);
			}     
			 */
			 
			conn.close();
		} 
			catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
