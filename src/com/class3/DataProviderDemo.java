package com.class3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DataProviderDemo {

    WebDriver driver;

 @DataProvider
 public Object[][] loginData(){
     Object [][] data = new Object[3][2];
     data[0][0] = "Hum@nhrm123";
     data[0][1] = "Admin";
     data[1][0] = "Hum@nhrm123";
     data[1][1] = "Admin";
     data[2][0] = "Hum@nhrm123";
     data[2][1] = "Admin";
     return data;
 }

    @BeforeMethod(alwaysRun = true)
    public void openBrowserAndLaunchApp() {
        System.setProperty("webdriver.chrome.driver",
                "src/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        // launch the application
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test(dataProvider = "loginData")
    public void validLogin(String username, String password) {
        // WebElement usernamefield = driver.findElement(By.id("txtUsername"));
        // usernamefield.sendKeys("");
        // usernamefield.clear();
        // usernamefield.click();

        driver.findElement(By.id("txtUsername")).sendKeys(username);
        driver.findElement(By.id("txtPassword")).sendKeys(password);
        driver.findElement(By.id("btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement welcomeAttribute = driver.findElement(By.xpath("//*[text()='Welcome Admin']"));
        if (welcomeAttribute.isDisplayed()) {
            System.out.println("Test is valid and Passed");
        } else {
            System.out.println("Test is failed");
        }
    }

    /*@Test(groups = "sprint1")
    public void validationOfTitle() {

        String expectedTitle = "Human Management System";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);
        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Test is final and title is same");
        } else {
            System.out.println("Test is failed");
        }
    }*/

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

}
