package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.dashboardPage;

import java.time.Duration;

public class DashboardTest extends BaseTest {
    String assLeave="/html/body/div/div[1]/div[2]/div[2]/div/div[3]/div/div[2]/div/div[1]";
    String LeaveList="/html/body/div/div[1]/div[2]/div[2]/div/div[3]/div/div[2]/div/div[2]";
    String ApplyLeave="/html/body/div/div[1]/div[2]/div[2]/div/div[3]/div/div[2]/div/div[4]";
    String myLeave="/html/body/div/div[1]/div[2]/div[2]/div/div[3]/div/div[2]/div/div[5]";
    String timeSheet="/html/body/div/div[1]/div[2]/div[2]/div/div[3]/div/div[2]/div/div[3]";
    String myTimeSheet="/html/body/div/div[1]/div[2]/div[2]/div/div[3]/div/div[2]/div/div[6]";
    @Test(priority = 1)
    public void testDashboard() {
        dashboardPage page=new dashboardPage(driver);
        page.openDashboardPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        String url=driver.getCurrentUrl();
        System.out.println(url);
        Assert.assertEquals(url,"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test(priority = 2)
    public void testQuickLaunch() {
        dashboardPage page=new dashboardPage(driver);
        page.QuickLaunch(assLeave);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/leave/assignLeave");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.navigate().back();
        System.out.println("1 done");

        page.QuickLaunch(myLeave);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/leave/viewMyLeaveList");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.navigate().back();
        System.out.println("2 done");

        page.QuickLaunch(LeaveList);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/leave/viewLeaveList");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.navigate().back();
        System.out.println("3 done");

        page.QuickLaunch(ApplyLeave);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/leave/applyLeave");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.navigate().back();
        System.out.println("4 done");

        page.QuickLaunch(timeSheet);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/time/viewEmployeeTimesheet");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.navigate().back();
        System.out.println("5 done");

        page.QuickLaunch(myTimeSheet);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/time/viewMyTimesheet");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.navigate().back();
        System.out.println("6 done");

    }


}
