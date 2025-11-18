package tests.adminTests;
import org.testng.annotations.Test;
import pages.LeavePage;
import tests.BaseTest;

import java.time.Duration;

public class LeaveTest extends BaseTest {

    @Test(priority=1)
    public void testLeave(){
        System.out.println("i am here");
        LeavePage page = new LeavePage(driver);
        page.OpenLeavePage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Test(priority=2)
    public void AssignValidLeave(){
        LeavePage page = new LeavePage(driver);
        page.AssignLeave(Fname,Leaveoption,fromdate,todate);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Test(priority=3)
    public void AssignInValidLeave(){
        LeavePage page = new LeavePage(driver);
        page.AssignLeave("",Leaveoption,fromdate,todate);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Test(priority=4)
    public void searchLeave(){
        LeavePage page = new LeavePage(driver);
        page.SearchLeave();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
}
