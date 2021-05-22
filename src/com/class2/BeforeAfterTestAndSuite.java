package com.class2;

import org.testng.annotations.*;

public class BeforeAfterTestAndSuite {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("I am before suite");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("I am after suite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("I am before test");
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
