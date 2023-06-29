package com.jsp.jdbcDemo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.dynamicCrudOperation.Student;

public class StudentDAO {
	private Connection getConnection() {
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/m10_e3?user=root&password=root";
			 conn = DriverManager.getConnection(url);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public String saveStudent(StudentDTO student) {
		String query="insert into student values(?,?,?,?)";
		Connection conn = getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, student.getId());
			ps.setString(2, student.getName());
			ps.setString(3, student.getEmail());
			ps.setString(4, student.getCourse());
			int execute = ps.executeUpdate();
			System.out.println(execute);
			return execute+" row of data is inserted";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "No data is inserted";
	}
	
	public StudentDTO getDataById(int id) {
		Connection connection = getConnection();
		String query="select * from student where id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet res = ps.executeQuery();
			StudentDTO dto = new StudentDTO();
			while(res.next()) {
				dto.setId(res.getInt("id"));
				dto.setName(res.getString("name"));
				dto.setEmail(res.getString("email"));
				dto.setCourse(res.getString("course"));
				return dto;
//				System.out.println(res.getInt(1)+" , "+res.getString(2)+" , "+res.getString(3)+" , "+res.getString(4));
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void getEmailById(int id) {
		Connection connection = getConnection();
		String query="Select email from student where id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			StudentDTO dto = new StudentDTO();
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				dto.setEmail(res.getString("email"));
				System.out.println(dto.getEmail());
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<StudentDTO> getAllStudents(){
		Connection connection = getConnection();
		String query="Select * from student";
		List<StudentDTO> list=null;
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet set = ps.executeQuery();
			if(set.isBeforeFirst()) {
				list=new ArrayList<StudentDTO>();
				while(set.next()) {
					StudentDTO dto = new StudentDTO();
					dto.setId(set.getInt(1));
					dto.setName(set.getString(2));
					dto.setEmail(set.getString(3));
					dto.setCourse(set.getString(4));
					list.add(dto);
				}
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public String saveAll(List<StudentDTO> list) {
		Connection connection = getConnection();
		String query="INSERT into student values(?,?,?,?)";
		try {
			int count=0;
			PreparedStatement ps = connection.prepareStatement(query);
			for(int i=0;i<list.size();i++) {
				StudentDTO dto=list.get(i);
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
		return null;
		
	}
}



















