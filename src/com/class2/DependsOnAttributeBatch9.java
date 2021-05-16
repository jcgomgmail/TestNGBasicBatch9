package com.class2;

import org.testng.annotations.Test;

public class DependsOnAttributeBatch9 {

    @Test
    public void launchApplication(){
        System.out.println("This is my login test");
    }

    @Test(dependsOnMethods = "launchApplication")
    public void enterCredentials(){
        System.out.println("This is my dependent method");
    }
}
