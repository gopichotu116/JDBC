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
import java.util.Properties;
import java.util.Scanner;

public class DataBaseOperator {
	public static void main(String[] args) {
		System.out.println("Enter the query");
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String query=reader.readLine();
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/m10_e3";
			FileInputStream stream= new FileInputStream("mydbinfo.properties");
			Properties pro = new Properties();
			pro.load(stream);
			Connection conn = DriverManager.getConnection(url,pro);
			Statement stmt = conn.createStatement();
			boolean res = stmt.execute(query);
			System.out.println(res);
			if(res) {
				ResultSet set = stmt.getResultSet();
				while(set.next()) {
					int id = set.getInt("id");
					String name = set.getString("name");
					String email=set.getString("email");
					String course=set.getString("course");
					System.out.println(id + "  " + name + "  " + email +
							"  " + course);
				}
			}
			else {
				conn.close();
			}
		} catch (IOException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}















