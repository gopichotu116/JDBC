package com.jsp.practice;

import java.io.FileInputStream;
import java.io.IOException;

public class Demo1 {
	public static void main(String[] args) throws IOException {
		FileInputStream stream=new FileInputStream("mydbinfo.properties");
		int n=stream.read();
		while(n!=-1) {
			System.out.print((char)n);
			n=stream.read();
		}
	}
}
