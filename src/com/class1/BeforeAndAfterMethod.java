package com.class1;

import org.testng.annotations.*;

public class BeforeAndAfterMethod {

	@BeforeTest
	public void beforeTest(){
		System.out.print("I am before test");
	}

	@AfterTest
	public void afterTest(){
		System.out.println("I am after test");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod");
	}

	@Test
	public void testMethodOne() {
		System.out.println("testMethodOne");
	}

	@Test
	public void testMethodTwo() {
		System.out.println("testMethodTwo");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod");
	}

}
