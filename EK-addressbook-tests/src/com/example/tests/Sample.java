package com.example.tests;

public class Sample {

	public static void main(String[] args) {
		//String b = "test   test  test";
		//String[] list = b.split("\\s+");
		
		String b = "    +7 (921) 123-45-67    ";
		b = b.trim();
		System.out.println(b);
		
		b = b.replaceAll("[ ()\\-]", "");
		
		System.out.println(b);
		System.out.println(b.matches("\\+\\d+"));
		//System.out.println(b.matches("\\+\\d+\\s*\\(\\d+\\)\\s*[\\d\\-]+"));
		//System.out.println(list.length);
		//System.out.println(list[0]);
		//System.out.println(list[1]);
		//System.out.println(list[2]);
	}
}
