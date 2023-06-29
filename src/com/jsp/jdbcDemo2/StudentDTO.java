package com.jsp.jdbcDemo2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
	private int id;
	private String name;
	private String email;
	private String course;
}
