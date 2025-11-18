package pages;

import net.bytebuddy.agent.builder.AgentBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class PIMPage {
    WebDriver driver;
    By PIMPath= By.xpath("//span[text()='PIM']");
    By AddEmployyButton=By.xpath("/html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[3]");
    By FirstName= By.name("firstName");
    By SecondName=By.name("middleName");
    By LastName=By.name("lastName");
    By checkbox=By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[2]/div/label");
    By usernameField= By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input");
    By passwordField=By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[1]/div/div[2]/input");
    By confirmPasswordField=By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[2]/div/div[2]/input");
    By button=By.cssSelector("button[type='submit']");
    By id=By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input");
    By errorMessage=By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/span");
    By personalpage= By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div/div[1]/div[1]/div[1]/h6");
    By EmploeeeList=By.xpath("/html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[2]");
    By deletebutton=By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[9]/div/button[2]");
    static String Sid;

    public PIMPage(WebDriver driver){
        this.driver=driver;
    }
    public void OpenPIMPage(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(PIMPath).click();

    }
    public String AddEmploee(String fname,String sname,String lname, String username,String pass) {
        driver.findElement(AddEmployyButton).click();
        driver.findElement(FirstName).sendKeys(fname);
        driver.findElement(SecondName).sendKeys(sname);
        driver.findElement(LastName).sendKeys(lname);
        driver.findElement(checkbox).click();
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(pass);
        driver.findElement(confirmPasswordField).sendKeys(pass);
        WebElement ID= driver.findElement(id);
        Sid=ID.getText();
        System.out.println(Sid);
        driver.findElement(button).click();
        return Sid;


        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }
    public String GetErrorMessage(){
        return driver.findElement(errorMessage).getText();

    }
    public int searchEmployee(String id){
        driver.findElement(EmploeeeList).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement IDField= driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input"));
        IDField.clear();
        IDField.sendKeys(id);
        WebElement SearchButton=driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]"));
        SearchButton.click();
        List<WebElement> records= driver.findElements(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div"));
        return records.size();
    }
    public int deleteEmployee() {
        WebElement delete = driver.findElement(deletebutton);
        delete.click();
        WebElement deleteButton = driver.findElement(By.xpath("/html/body/div/div[3]/div/div/div/div[3]/button[2]"));
        deleteButton.click();
        List<WebElement> records= driver.findElements(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div"));
        return records.size();
    }

    }
