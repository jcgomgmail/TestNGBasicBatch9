package com.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SoftAssertionHRMSBatch9 {

    WebDriver driver;

    @BeforeMethod
    public void launchApplication(){
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void loginAndValidateTitle(){

        String title = "Human Resource Management System";
        String actualTitle = driver.getTitle();
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(actualTitle, title);

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement welcomeAttribute = driver.findElement(By.xpath("//*[text()='Welcome Admin']"));

        String receivedvalue = welcomeAttribute.getText();
        String existedvalue = "Welcome Admin12345";

        soft.assertEquals(receivedvalue, existedvalue);
        System.out.print("My test case is not working according to the user story");
        soft.assertAll();
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }


}
