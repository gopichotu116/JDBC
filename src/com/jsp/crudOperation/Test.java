package com.jsp.crudOperation;

import java.util.List;

public class Test 
{
	public static void main(String[] args) 
	{
		ListGiven given = new ListGiven();
		List<Integer> list=given.getList();
		given=null;
		list.forEach(System.out::println);
	}

}
