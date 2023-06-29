package com.jsp.dynamicCrudOperation;

import java.util.List;

public class TestDAO {
	public static void main(String[] args) {
		
		Student s1 = new Student(105,"Priya","bharu@gmail.com","Spring");
//		Student s2 = new Student(502,"Lakshmi","lucky@gmail.com","Hibernate");
//	
		StudentDAO dao = new StudentDAO();
//		dao.saveStudent(s2);
		System.out.println(dao.updateStudent(s1));
//		dao.getDataById(101);
//		List<Student> list = dao.getAllStudent();
//		if(list!=null) {
//			list.forEach(System.out::println);
//		}
//		else {
//			System.out.println("No Student data found in DB");
//		}
		
	}
}
