package tests.adminTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PIMPage;
import tests.BaseTest;

import java.time.Duration;

public class PIMTest extends BaseTest {
    static String Emplyeeid;
    @Test(priority = 1)
    public void testPIM() {
        PIMPage page=new PIMPage(driver);
        page.OpenPIMPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Test(priority = 2)
    public void testAddEmployee() {
        PIMPage page=new PIMPage(driver);
        Emplyeeid=page.AddEmploee(Fname,Sname,Lname,choosenUsername,newPassword);
        //Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div/div[1]/div[1]/div[1]/h6")).getText(),)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Test(priority = 3)
    public void testAddExistingEmployee() {
        PIMPage page=new PIMPage(driver);
        page.AddEmploee(Fname,Sname,Lname,choosenUsername,newPassword);
        Assert.assertEquals(page.GetErrorMessage(),"Username already exists");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Test(priority = 4)
    public void searchExistentEmployee(){
        PIMPage page= new PIMPage(driver);
        int size=page.searchEmployee(Emplyeeid);

        Assert.assertTrue(size>0,"Expected records for existing employee, but none found.");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Test(priority = 5)
    public void searchNonExistentEmployee(){
        PIMPage page= new PIMPage(driver);
        int size=page.searchEmployee("012");
        Assert.assertTrue(size>0,"Expected 'No Records Found' message, but it was missing.");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Test(priority = 6)
    public void testDeleteEmployee() {
        PIMPage page=new PIMPage(driver);
        int size=page.deleteEmployee();
        Assert.assertTrue(size>0,"Expected 'No Records Found' message, but it was missing.");
    }
}
