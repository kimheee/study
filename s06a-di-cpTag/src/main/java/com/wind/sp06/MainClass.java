package com.wind.sp06;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		String configLocation = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		
		Family family = ctx.getBean("family" , Family.class);
		ctx.close();
		
		System.out.println("아빠 : " + family.getFatherName());
		System.out.println("엄마 : " + family.getMotherName());
		System.out.println("동생 : " + family.getBrotherName());

	}

}
