package pages;

import io.opentelemetry.context.internal.shaded.WeakConcurrentMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver webdriver;
    By usernameField=By.cssSelector("input[name='username']");
    By passwordField=By.name("password");
    By loginButton=By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]");
    By error1= By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p");
    By error2= By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span");

    public LoginPage(WebDriver driver) {
        this.webdriver=driver;
    }

    public void enterUsername(String username){
        webdriver.findElement(usernameField).sendKeys(username);
    }
    public void enterPassword(String password){
        webdriver.findElement(passwordField).sendKeys(password);
    }
    public void clickLogin(){
        webdriver.findElement(loginButton).click();
    }
    public String getErrorMessage1(){
        return webdriver.findElement(error1).getText();
    }
    public String getErrorMessage2(){
        return webdriver.findElement(error2).getText();
    }

}
