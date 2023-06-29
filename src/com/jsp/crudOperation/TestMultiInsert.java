package com.jsp.crudOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestMultiInsert {
	public static void main(String[] args){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/m10_e3";
			String user="root";
			String pass="root";
			Connection conn = DriverManager.getConnection(url,user,pass);
			Statement stmt = conn.createStatement();
			String query1="Insert into student1 values(6 ,'Pawan Kalyan','pk113@gmail.com','Java')"; 
			String query2="Insert into student1 values(7 ,'Mahesh','mb28@gmail.com','Python')"; 
			String query3="Insert into student1 values(8 ,'NTR','ntr30@gmail.com','MernStack')"; 
			String query4="Insert into student1 values(9 ,'AA','aa27@gmail.com','Spring')"; 
			String query5="Insert into student1 values(10 ,'Ram Charan','ram16@gmail.com','Hibernate')"; 
			String update="update student1 set name='Gopi' where name='Mahes'";
			String delete="delete from student1 where name='Gopi'";
			String select="Select * from student1";
			stmt.addBatch(query1);
			stmt.addBatch(query2);
			stmt.addBatch(delete);
//			stmt.addBatch(select); // Exception
			stmt.addBatch(update);
			int[] batch = stmt.executeBatch();
			for(Integer e:batch) {
				System.out.println(e);
			}
			
			System.out.println(batch.length+" rows of data is Updated");
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
