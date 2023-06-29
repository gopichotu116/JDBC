package com.jsp.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestInsert {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/m10_e3";
			String user="root";
			String pass="root";
			Connection conn = DriverManager.getConnection(url,user,pass);
			String query="insert into student (id,name,email) values(?,?,?)";
//			 ? -> place holders
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1,601);
			ps.setString(2, "Brahmi");
			ps.setString(3, "brahmi@116");
			int res = ps.executeUpdate();
			
			conn.close();
			System.out.println(res+" row of data stored");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
