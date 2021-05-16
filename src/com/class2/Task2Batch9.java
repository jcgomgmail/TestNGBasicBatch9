package com.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task2Batch9 {

    WebDriver driver;

    @BeforeMethod
    public void openBrowserAndLaunchApp() {
        System.setProperty("webdriver.chrome.driver",
                "src/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        // launch the application
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void invalidLogin(){

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
       // driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement errorField = driver.findElement(By.id("spanMessage"));

        String receivingtext = errorField.getText();
        String actualtext = "Password cannot be empty";

        Assert.assertEquals(receivingtext, actualtext);
        System.out.println("Test is passed");

        /*if(receivingtext.equals(actualtext)){
            System.out.println("Test is passed and error is displayed");
        }else{
            System.out.println("Test is failed and error is not available");
        }*/
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }


}
