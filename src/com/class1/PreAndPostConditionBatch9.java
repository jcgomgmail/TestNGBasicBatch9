package com.class1;

import org.testng.annotations.*;

public class PreAndPostConditionBatch9 {

	@BeforeClass
	public void beforeTestMethod(){
		System.out.println("I am before class");
	}
	
	
	@AfterClass
	public void afterTestMethod(){
		System.out.println("I am after class");
	}
	
	@BeforeMethod
	public void beforeMethod(){
		System.out.println("I am before method function which will execute before every test");
	}
	
	@AfterMethod
	public void afterMethod(){
		System.out.println("I am after method function which will execute after every test");
	}
	
	@Test
	public void firstFunction(){
		System.out.println("I am dddddd test");
	}
	
	@Test
	public void secondFunction(){
		System.out.println("I am aaaaa test");
	}
	
	@Test
	public void thirdFunction(){
		System.out.println("I am cccc test");
	}
	
}
