package com.class3;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Grouping {

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I am before method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("I am after method");
    }

    @Test(groups = "smoke")
    public void firstMethod(){
        System.out.println("I am first method");
    }

    @Test(groups = "testone")
    public void secondMethod(){
        System.out.println("I am second method");
    }

    @Test (groups = "smoke")
    public void thirdMethod(){
        System.out.println("I am third method");
    }

    @Test (groups = "smoke")
    public void fourthMethod(){
        System.out.println("I am fourth method");
    }
}
