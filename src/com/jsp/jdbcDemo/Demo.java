package com.jsp.jdbcDemo;

public class Demo {
	public static void main(String[] args) {
		String s="Bhaskar";
		String temp="";
		for(int i=s.length()-1;i>=0;i--) {
			temp+=s.charAt(i);
		}
		System.out.println(temp.trim());
	}
}
