package com.jsp.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
*/
//jdbc:oracle:thin:username/password@my.oracle.server.domain.com:1521:DBName

public class TestConnection 
{
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
//			Class.forName(")
			String url="jdbc:mysql://localhost:3306/m10_e3";
			String user="root";
			String pass="root";
			// creating a connection 
			
			Connection connection=DriverManager.getConnection(url,user,pass);
			System.out.println("connected");
		}
		catch (  SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
