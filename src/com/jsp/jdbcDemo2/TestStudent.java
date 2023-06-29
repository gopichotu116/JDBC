package com.jsp.jdbcDemo2;

import java.util.ArrayList;
import java.util.List;

public class TestStudent {
	public static void main(String[] args) {
		
		StudentDTO s1 = new StudentDTO(105,"Amrish","daa@116","Java");
		StudentDAO dao = new StudentDAO();
//		dao.saveStudent(s1);
//		System.out.println(dao.getDataById(101));
//		dao.getEmailById(101);
//		List<StudentDTO> list = dao.getAllStudents();
//		if(list!=null) list.forEach(System.out::println);
		
//		List<StudentDTO> list= {
//				new StudentDTO(201,"Vishnu","vishnu@gmail.com","python"),
//				new StudentDTO(202, "Venky", "venky@gmail", "Java")
//		};
//		dao.saveAll(list);
		StudentDTO s2 = new StudentDTO(201,"Vishnu","vishnu@gmail.com","python");
		StudentDTO s3 = new StudentDTO(202, "Venky", "venky@gmail", "Java");
		List<StudentDTO> list=new ArrayList<StudentDTO>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		dao.saveAll(list);
		
		
	}
}
