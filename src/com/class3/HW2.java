package com.class3;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HW2 {
    WebDriver driver;
    public String usernameAdmin = "Admin";
    public String passwordAdmin = "Hum@nhrm123";

    @BeforeMethod(alwaysRun = true)
    public void openAndNavigate() {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        driver = new ChromeDriver ();
        driver.navigate().to("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod (alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }

    @Test(dataProvider = "AddEmployee", groups = "regression")
    public void AddEmployees(String firstName, String lastName, String userName, String password) throws InterruptedException, IOException {
        //login
        driver.findElement( By.id("txtUsername")).sendKeys(usernameAdmin);
        driver.findElement(By.id("txtPassword")).sendKeys(passwordAdmin);
        driver.findElement(By.id("btnLogin")).click();
        //navigating to add Employee
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement menu = driver.findElement(By.xpath("//a[@id = 'menu_pim_viewPimModule']/b"));
        menu.click();
        //using js to click on a PIM button
        //JavascriptExecutor js=(JavascriptExecutor)driver;
        //js.executeScript("arguments[0].click();",menu);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement addEmployee=driver.findElement(By.id("menu_pim_addEmployee"));
        addEmployee.click();
        //js.executeScript("arguments[0].click();",addEmployee);

        //adding employee
        WebElement addFistName = driver.findElement(By.cssSelector("input#firstName"));
        WebElement addLastName = driver.findElement(By.cssSelector("input#lastName"));
        addFistName.sendKeys(firstName);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        addLastName.sendKeys(lastName);
        driver.findElement(By.cssSelector("input#chkLogin")).click();
        //adding login credentials
        WebElement addUserName = driver.findElement(By.cssSelector("input#user_name"));
        WebElement addPassword = driver.findElement(By.cssSelector("input#user_password"));
        WebElement confirmPassword = driver.findElement(By.cssSelector("input#re_password"));
        addUserName.sendKeys(userName);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        addPassword.sendKeys(password);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        confirmPassword.sendKeys(password);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement saveButton = driver.findElement(By.cssSelector("input#btnSave"));
        saveButton.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //validating that employee is added successfully
        WebElement title = driver.findElement(By.xpath("//div[@id='content']/div/div/div/h1[1]"));
        Assert.assertTrue(title.isDisplayed(), "Name is displayed");
    }

    @DataProvider
    public Object[][] AddEmployee() {
        Object[][] data = new Object[1][4];
        data[0][0] = "Elias1";
        data[0][1] = "Alvial1";
        data[0][2] = "Eliasalv123";
        data[0][3] = "Syntax@123";
        return data;
    }
}

