package com.jsp.jdbcDemo;

import java.sql.*;
/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
*/
import com.mysql.cj.jdbc.Driver;
public class TestConnection2 
{
	public static void main(String[] args) {
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			String url="jdbc:mysql://localhost:3306/m10_e3";
			String user="root";
			String pass="root";
			// creating a connection 
			
			Connection connection=DriverManager.getConnection(url,user,pass);
			System.out.println("connected");
		}
		catch (  SQLException e) {
			e.printStackTrace();
		}
	}
}
