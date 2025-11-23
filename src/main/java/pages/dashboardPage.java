package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class dashboardPage {
    WebDriver driver;
    By dashboard= By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[8]");
    public dashboardPage(WebDriver driver){
        this.driver=driver;

    }

    public void openDashboardPage(){

        driver.findElement(dashboard).click();
    }
    public void QuickLaunch(String option){
        driver.findElement(By.xpath(option)).click();
    }
}
