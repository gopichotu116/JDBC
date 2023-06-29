package com.jsp.dynamicCrudOperation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseOperator2 {
	public static void main(String[] args) {
		System.out.println("enter the query");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
		try {
			String query = reader.readLine();
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/m10_e3?user=root&password=root";
			Connection conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
			boolean res = stmt.execute(query);
			System.out.println(res);
			if(res) {
				ResultSet set = stmt.getResultSet();
				while(set.next()) {
					int id=set.getInt(1);
					String name=set.getString(2);
					String email=set.getString(3);
					String course=set.getString(4);
					System.out.println("[ Id="+id+" , "+"Name="+name+" , "+"Email="+email+" , "+"Course="+course+" ]");
				}
			}
			conn.close();
		} catch (IOException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
