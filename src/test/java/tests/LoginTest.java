package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;

import java.time.Duration;

public class LoginTest extends BaseTest{

    //WebDriver driver=new ChromeDriver();
    @Test(priority = 4)
    public void testValidLogin(){
        LoginPage page= new LoginPage(driver);
        page.enterUsername(username);
        page.enterPassword(password);
        page.clickLogin();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
    @Test (priority = 3)
    public void testInValidUsername(){
        LoginPage page= new LoginPage(driver);
        page.enterUsername("Admi");
        page.enterPassword(password);
        page.clickLogin();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String error1=page.getErrorMessage1();
        Assert.assertEquals(error1,("Invalid credentials"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Test (priority = 2)
    public void testInvalidPassword(){
        LoginPage page= new LoginPage(driver);
        page.enterUsername(username);
        page.enterPassword("admin");
        page.clickLogin();
        String error1=page.getErrorMessage1();
        Assert.assertEquals(error1,("Invalid credentials"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Test (priority = 1)
    public void testBlankfields(){
        LoginPage page= new LoginPage(driver);
        page.enterUsername("");
        page.enterPassword("");
        page.clickLogin();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String error2=page.getErrorMessage2();
        Assert.assertEquals(error2,("Required"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

}
