package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {
    protected static WebDriver driver;
    static String username="Admin";
    static String password="admin123";
    static String Fname="Siddharth";
    static String Sname="Kumar";
    static String Lname="Chaudhary";
    static String fromdate="2022-12-02";
    static String todate="2022-12-31";
    static String Leaveoption="CAN-FMLA";
    static String choosenUsername="Siddharth Chaudhary";
    static String newPassword="Siddharth@123";


    @BeforeSuite
    public void setUp(){
        driver= new EdgeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); }
//   @AfterSuite
//    public void tearDown(){
//        driver.quit();
//    }
}
