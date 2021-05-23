package com.class4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.CommonMethods;

import java.util.concurrent.TimeUnit;

public class ParallelTest extends CommonMethods {

    @Test()
    public void validLogin() {
        // WebElement usernamefield = driver.findElement(By.id("txtUsername"));
        // usernamefield.sendKeys("");
        // usernamefield.clear();
        // usernamefield.click();

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement welcomeAttribute = driver.findElement(By.xpath("//*[text()='Welcome Admin']"));
        if (welcomeAttribute.isDisplayed()) {
            System.out.println("Test is valid and Passed");
        } else {
            System.out.println("Test is failed");
        }
    }

    @Test()
    public void validationOfTitle() {

        String expectedTitle = "Human Management System";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);
        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Test is final and title is same");
        } else {
            System.out.println("Test is failed");
        }
    }
}
