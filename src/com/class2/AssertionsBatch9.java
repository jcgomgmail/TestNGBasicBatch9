package com.class2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsBatch9 {

    @Test
    public void assertVerification(){


        String expectedText = "This is my software testing academy";
        String actualText = "This is my software testing academy";
        System.out.println("My receiving text is " + expectedText);
       Assert.assertTrue(true);
      //  Assert.assertFalse(false);
        System.out.println("Checking for another assertion");
        Assert.assertEquals(expectedText, actualText);
        System.out.println("My test is working fine and it is passed");


    }






}
