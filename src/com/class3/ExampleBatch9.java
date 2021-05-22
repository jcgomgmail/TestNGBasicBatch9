package com.class3;

import org.testng.annotations.Test;

public class ExampleBatch9 {

	@Test(groups = "smoke")
	public void firstFunction(){
		System.out.println("I am smoke test");
	}

	@Test(groups = "smoke")
	public void secondFunction(){
		System.out.println("I am smoke test");
	}

	@Test(groups = "regression")
	public void thirdFunction(){
		System.out.println("I am cccccc test");
	}

	@Test(groups = "smoke")
	public void fourthFunction(){
		System.out.println("I am b test");
	}

}
