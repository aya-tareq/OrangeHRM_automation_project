package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LeavePage {
    WebDriver driver;
    By leave= By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[3]");
    By AssLeave=By.xpath("/html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[7]");
    By NameField=By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div/div/div[2]/div/div/input");
    By TypeField=By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/div");
    By FromDateField=By.xpath("//html/body/div/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[1]/div/div[2]/div/div/input");
    By ToDateField=By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[2]/div/div[2]/div/div/input");
    By AssignButton=By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[5]/button");
    static String option;

    public LeavePage(WebDriver driver){
        this.driver=driver;
    }

    public void OpenLeavePage(){
        driver.findElement(leave).click();
    }

    public void AssignLeave(String name,String option,String fromdate, String todate){
        this.option=option;
        driver.findElement(AssLeave).click();
        WebElement Name= driver.findElement(NameField);
        Name.clear();
        Name.sendKeys(name);
        driver.findElement(TypeField).click();
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/div/div/div[1]")).click();
        WebElement FromDate= driver.findElement(FromDateField);
        WebElement ToDate= driver.findElement(ToDateField);
        FromDate.clear();
        ToDate.clear();
        FromDate.sendKeys(fromdate);
        ToDate.clear();

        ToDate.sendKeys(todate);
        WebElement assignButton=driver.findElement(AssignButton);
        assignButton.click();

    }
    public void SearchLeave(){
        WebElement searchName=driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/div/div[1]/div/div[2]/div/div/input"));
        searchName.clear();
        WebElement Name= driver.findElement(NameField);
        searchName.sendKeys(Name.getText());
        WebElement searchLtype=driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div"));
        searchLtype.clear();
        WebElement LeaveType= driver.findElement(TypeField);
        LeaveType.click();
        driver.findElement(By.xpath("//div[@role='option']//span[text()='" + option + "']")).click();


    }

}
