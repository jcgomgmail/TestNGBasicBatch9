package com.class2;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionBatch9 {

    @Test
    public void softAssertionValidation(){
        String expectedText = "This is my testing world";
        String actualText = "THIS is my testing world";

        SoftAssert softassert = new SoftAssert();

        softassert.assertEquals(actualText, expectedText);
        System.out.println("My code after first assertion");

        softassert.assertTrue(false);
        System.out.println("My code after second assertion");

        softassert.assertFalse(true);
        System.out.println("My code after third assertion");

        String expectedTextsecond = "This is my testing world";
        String actualTextsecond = "This is my testing world";
        softassert.assertEquals(actualTextsecond, expectedTextsecond);

        softassert.assertAll();

    }
}
