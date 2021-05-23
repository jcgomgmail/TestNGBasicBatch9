package com.class4;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
    public class HW {

        WebDriver driver;
        @BeforeMethod(alwaysRun = true)
        public void launchApplication() {
            System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
            driver = new ChromeDriver();
            // launch the application
            driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.");
            driver.manage().window().maximize();

        }
        @AfterMethod(alwaysRun = true)
        public void teardown() {
            driver.quit();
        }

        @Test(dataProvider = "addedEmployees", groups = "regression")
        public void login(String firstName, String lastName, String userName, String password, String confirmPassword) {
            driver.findElement(By.id("txtUsername")).sendKeys("Admin");
            driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
            driver.findElement(By.id("btnLogin")).click();

            WebElement menu = driver.findElement(By.id("menu_pim_viewPimModule"));
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click()", menu);
            WebElement addemployee= driver.findElement(By.linkText("Add Employee"));

            // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            js.executeScript("arguments[0].click()", addemployee);
           //WebElement addemployee= driver.findElement(By.linkText("Add Employee"));
            //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            WebElement checkbox = driver.findElement(By.id("chkLogin"));
            js.executeScript("arguments[0].click()", checkbox);

            driver.findElement(By.id("firstName")).sendKeys(firstName);
            driver.findElement(By.id("lastName")).sendKeys(lastName);
            driver.findElement(By.id("user_name")).sendKeys(userName);
            driver.findElement(By.id("user_password")).sendKeys(password);
            driver.findElement(By.id("re_password")).sendKeys(confirmPassword);
            WebElement savebutton = driver.findElement(By.xpath("//*[@id=\"btnSave\"]"));
            js.executeScript("arguments[0].click", savebutton);
            //TakesScreenshot ts = (TakesScreenshot) driver;
           /* File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenshotAs, new File("Screenshots/HRMS/Added Employees.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }*/
            //WebElement addedEmployee = driver.findElement(By.xpath("//*[@id=\"profile-pic\"]/h1"));
            //Assert.assertTrue(addedEmployee.isDisplayed(), "Name is displayed");
        }

        @DataProvider
        public Object[][] addedEmployees() {
            Object[][] data = new Object[5][5];
            data[0][0] = "Testone";
            data[0][1] = "testdataone";
            data[0][2] = "Test@123";
            data[0][3] = "ksenia123!K";
            data[0][4] = "ksenia123!K";
            data[1][0] = "Testtow";
            data[1][1] = "testdatatwo";
            data[1][2] = "Test@456";
            data[1][3] = "ksenia123!K";
            data[1][4] = "ksenia123!K";
            data[2][0] = "Cherry";
            data[2][1] = "Green";
            data[2][2] = "Cherrygreen";
            data[2][3] = "ksenia123!K";
            data[2][4] = "ksenia123!K";
            data[3][0] = "CherryBlack";
            data[3][1] = "Black";
            data[3][2] = "Cherryblack";
            data[3][3] = "ksenia123!K";
            data[3][4] = "ksenia123!K";
            data[4][0] = "CherryBlue";
            data[4][1] = "Blue";
            data[4][2] = "Cherryblue";
            data[4][3] = "ksenia123!K";
            data[4][4] = "ksenia123!K";
            return data;
        }
    }
