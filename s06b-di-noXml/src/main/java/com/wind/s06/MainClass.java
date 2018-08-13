package com.wind.s06;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		//AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		Student student1 = ctx.getBean("student1", Student.class);
		
		System.out.println("student1");
		System.out.println("이름 : " + student1.getName());
		System.out.println("나이 : " + student1.getAge());

		System.out.println();
		
		Student student2 = ctx.getBean("student2", Student.class);
		
		System.out.println("student2");
		System.out.println("이름 : " + student2.getName());
		System.out.println("나이 : " + student2.getAge());
		
		System.out.println();
		
		Conan student3 = ctx.getBean("conan", Conan.class);
		student3.setName("코난");
		student3.setAge(10);
		
		System.out.println("student3");
		System.out.println("이름 : " + student3.getName());
		System.out.println("나이 : " + student3.getAge());
	}

}
