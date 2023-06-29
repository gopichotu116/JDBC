package com.jsp.crudOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *  To get connection with JDBC:-
 *  --------------------------------
 *  1) Import package(DB library)
 *  2) Load and Register Driver
 *  3) Establish connection
 *  4) Create a statement
 *  5) Execute statement
 *  6) Processing the result (by using select query)
 *  7) Close connection
 */
public class TestInsert 
{
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/m10_e3";
			String user="root";
			String pass="root";
			
			Connection conn=DriverManager.getConnection(url,user,pass);
			
			Statement stmt = conn.createStatement();
			
			// Insert query
			
//			stmt.execute("Insert into student values(101,'Rajesh','rajesh@gmail.com','python'");
//			String query="Insert into student values(101,'Rajesh','rajesh@gmail.com','python')";
//			boolean excecute=stmt.execute(query);
//			System.out.println(excecute);
//			int res=stmt.executeUpdate(query);
//			System.out.println(res);
			
			// Update query
//			String query2="Update student set name='Bahubali' "
//					+ "where name='Gopichand'";
//			int res2=stmt.executeUpdate(query2);
//			System.out.println(res2);
			
			// Delete query
			
			String query3 ="Delete from student where id=101";
			int res3=stmt.executeUpdate(query3);
			System.out.println(res3);
			
			
			conn.close();
			
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
