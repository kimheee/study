package com.wind.s06;

public class Student {
	
	// 이름, 나이, 취미, 키, 몸무게
	private String name;
	private int age;
	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() { 
		return name; 
	}
	public int getAge() { 
		return age; 
	}


	public void setName(String name) { 
		this.name = name; 
	}
	public void setAge(int age) { 
		this.age = age; 
	}

	
}