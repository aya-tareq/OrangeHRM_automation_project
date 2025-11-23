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
    static public String username="Admin";
    static public String password="admin123";
    static public String Fname="Siddharth";
    static public String Sname="Kumar";
    static public String Lname="Chaudhary";
    static public String fromdate="2022-12-02";
    static public String todate="2022-12-31";
    static public String Leaveoption="CAN-FMLA";
    static public String choosenUsername="Siddharth Chaudhary";
    static public String newPassword="Siddharth@123";


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
