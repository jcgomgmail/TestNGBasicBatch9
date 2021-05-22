package com.class1;

import org.testng.annotations.Test;

public class ExampleBatch9 {

	@Test(groups = "regression")
	public void firstFunction(){
		System.out.println("I am smoke test");
	}

	@Test()
	public void secondFunction(){
		System.out.println("I am smoke test");
	}

	@Test
	public void thirdFunction(){
		System.out.println("I am cccccc test");
	}

	@Test
	public void fourthFunction(){
		System.out.println("I am b test");
	}

}
