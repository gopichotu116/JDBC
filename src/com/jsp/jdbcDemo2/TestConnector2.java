package com.jsp.jdbcDemo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *  1) creating a connection
 *  2) create a statement/query
 *  3) excecute statement/query
 *  4) store data in result set
 *  5) close connection
 */
public class TestConnector2 
{
	public static void main(String[] args) throws SQLException {
		
		// 1) create a connection
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/m10_e3","root","root");
		
		// 2)create a statement/query
		Statement stmt=con.createStatement();
		String s="select id,name from student";
		
		// 3,4) excecute query & store in a result set
		ResultSet rs=stmt.executeQuery(s);
		System.out.println(rs);
		while(rs.next()) {
			int id=rs.getInt("id");
			String name=rs.getString("name");
			System.out.println(id+"  "+name);
		}
		
		// 5)close connection
		con.close();
	}

}
