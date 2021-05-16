package com.class2;

import org.testng.annotations.Test;

public class PriotityBatch9 {

    @Test(priority = 2)
    public void logoutMethod(){
        System.out.println("This execution should come later");
    }

    @Test(priority = 1)
    public void loginMethod(){
        System.out.println("This execution should come first");
    }

    @Test(priority = 2)
    public void enterCredentialsMethod(){
        System.out.println("This execution should come in the end");
    }

    @Test(priority = 4)
    public void enterInvalidCrdentials(){
        System.out.println("This execution should come at number 4");
    }

    @Test(priority = 5)
    public void anotherTestMethod(){
        System.out.println("This execution should come in the end");
    }

}
