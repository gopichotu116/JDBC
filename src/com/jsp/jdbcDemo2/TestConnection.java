package com.jsp.jdbcDemo2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class TestConnection {

	public static void main(String[] args) {
		try {
			// 1 way to load and register the driver
//			Driver driver = new Driver();
//			DriverManager.registerDriver(driver);
			
			// 2nd way
			Class.forName("com.mysql.cj.jdbc.Driver");
			
	/**		String url="jdbc:mysql://localhost:3306/m10_e3";
			String user="root";
			String password="root";
			Connection conn = DriverManager.getConnection(url, user, password);
	*/
	/**		String url="jdbc:mysql://localhost:3306/m10_e3?user=root&password=root";
			Connection conn = DriverManager.getConnection(url);
	*/
	/**		String url="jdbc:mysql://localhost:3306/m10_e3";
			Properties pro = new Properties();
			pro.setProperty("user", "root");
			pro.setProperty("password", "root");
			Connection conn = DriverManager.getConnection(url, pro);
	*/
			String url="jdbc:mysql://localhost:3306/m10_e3";
			FileInputStream stream=new  FileInputStream("mydbinfo.properties");
			Properties pro = new Properties();
			pro.load(stream);
			Connection conn = DriverManager.getConnection(url, pro);
			Statement statement = conn.createStatement();
			
	/**		Insert query:-
			-------------
			String query="insert into student values(4,'Sai','sai@116','Java')";
			int executeUpdate = statement.executeUpdate(query);
			boolean execute =statement.execute(query);
			System.out.println(executeUpdate);
			System.out.println(execute);
	*/
			
	/**		Update query:-
			--------------
			String query="update student set name='Rajamouli' where id=1";
			boolean execute = statement.execute(query);
			int executeUpdate = statement.executeUpdate(query);
			System.out.println(execute);
			System.out.println(executeUpdate);
	*/
			
	/**		Delete query:-
			-------------
			String query="Delete from student where id=3";
			boolean execute = statement.execute(query);
			int executeUpdate = statement.executeUpdate(query);
			System.out.println(execute);
			System.out.println(executeUpdate);
	*/
			String query="Select * from student";
			boolean execute = statement.execute(query);
//			int executeUpdate = statement.executeUpdate(query); // we can't use this method
//			System.out.println(executeUpdate);
			ResultSet rs = statement.executeQuery(query);
			System.out.println(rs); // returns address
			
	/**		while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println("--------------------------------------------");
			}
	*/		
	/**		while(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String email=rs.getString(3);
				String course=rs.getString(3);
				System.out.println("[id="+id+","+"name="+name+","+"email="+email+","+"couse="+course+"]");
			}
	*/		
	/**		while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String email=rs.getString("email");
				String course=rs.getString("course");
				System.out.println("[id="+id+","+"name="+name+","+"email="+email+","+"couse="+course+"]");
			}
	*/
			ResultSet set = statement.getResultSet();
			while(set.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String email=rs.getString("email");
				String course=rs.getString("course");
				System.out.println("[id="+id+","+"name="+name+","+"email="+email+","+"couse="+course+"]");
			}
			ResultSetMetaData rsmd=rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			System.out.println(columnCount);
			String columnLabel = rsmd.getColumnLabel(2);
			System.out.println(columnLabel);
	    // close the connection
			conn.close(); 
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
