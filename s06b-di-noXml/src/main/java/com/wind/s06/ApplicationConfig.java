package com.wind.s06;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
	
	@Bean
	public Student student1() {		
		Student student = new Student("오드리 햅번", 25);		
		return student;		
	}
	
	@Bean
	public Student student2() {		
		Student student = new Student("그레고리펙", 30);
		return student;
	}

}
