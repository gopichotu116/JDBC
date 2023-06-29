package com.jsp.dynamicCrudOperation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.imageio.stream.FileImageInputStream;

public class StudentDAO {
	private Connection getConnection() {
		Connection connection=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/m10_e3";
		 FileInputStream stream=new FileInputStream("mydbinfo.properties");
		 Properties pro = new Properties();
		 pro.load(stream);
		 connection= DriverManager.getConnection(url,pro);
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	String saveStudent(Student student) {
		try {
			String query="insert into student values(?,?,?,?)";
			Connection conn=getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1,student.getId());
			ps.setString(2, student.getName());
			ps.setString(3, student.getEmail());
			ps.setString(4, student.getCourse());
			int res = ps.executeUpdate();
			
			conn.close();
			return res+" row of data stored";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "no data is stored";
		
	}
	
	public String updateStudent(Student student) {
		try {
			String query=
			"update student set name=?,email=?,course=? where id=?";
			Connection conn=getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, student.getName());
			ps.setString(2, student.getEmail());
			ps.setString(3, student.getCourse());
			ps.setInt(4, student.getId());
			int res = ps.executeUpdate();
			
			conn.close();
			return res+" row of data Updated";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void getDataById(int id) {
		try {
			String query=
			"select * from student where id=?";
			Connection conn=getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet set = ps.executeQuery();
			while(set.next()) {
				System.out.println(set.getInt(1));
				System.out.println(set.getString(2));
				System.out.println(set.getString(3));
				System.out.println(set.getString(4));
			}
			conn.close();
		} catch ( SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// return the list of student object 
	public List<Student> getAllStudent(){
		String query="Select * from student";
		Connection conn = getConnection();
		List<Student> list=null;
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet set = ps.executeQuery();
			// boolean check=set.next();
			if(set.isBeforeFirst()) // if(check)
			{
				list=new ArrayList<>();
				while(set.next()) // while(check)
				{
					Student s = new Student();
					s.setId(set.getInt(1));
					s.setName(set.getString(2));
					s.setEmail(set.getString(3));
					s.setCourse(set.getString(4));
					list.add(s);
					// check=set.next();
				}
			}
			conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void saveAll(List<Student> list) {
		Connection connection = getConnection();
		String query="INSERT into student values(?,?,?,?)";
		try {
			int count=0;
			PreparedStatement ps = connection.prepareStatement(query);
			for(int i=0;i<list.size();i++) {
				Student dto=list.get(i);
				ps.setInt(1, dto.getId());
				ps.setString(2, dto.getName());
				ps.setString(3, dto.getEmail());
				ps.setString(4, dto.getCourse());
				int update = ps.executeUpdate();
				count++;
			}
			System.out.println(count+" rows of data is inserted");
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}




















