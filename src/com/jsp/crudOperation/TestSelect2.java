package com.jsp.crudOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSelect2 {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306:m10_e3","root","root");
			
			Statement stmt=conn.createStatement();
			
			String query="select * from student where name='Bhaskar'";
			
			boolean result=stmt.execute(query);
			System.out.println(result);
			
			ResultSet set=stmt.getResultSet();
				int id=set.getInt("id");
				String name=set.getString("name");
				String email=set.getString("email");
				String course=set.getString("cource");
				System.out.println(id+" "+name+" "+email+" "+course);
			
		} catch ( SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
