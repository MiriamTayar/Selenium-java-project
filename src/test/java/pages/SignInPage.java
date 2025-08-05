package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//מסך כניסה למערכת----------------
public class SignInPage {
    WebDriver driver;

    //constructor
    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    //לוקייטור  של כניסה לחשבון
    private By MyAccountLocator = By.xpath("//*[@id=\"platform_modernisation_header\"]/header/div[1]/nav/div[2]/div[2]/div[2]/div/a/img");
    //לוקייטור של מייל
    private By EmailLocator= By.name("username");
    //לוקייטור של סיסמה
    private By PasswordLocator= By.name("password");
    //לוקייטור כפתור כניסה
    private By SignInLocator= By.name("SignInNow");

    //Method
    //פונקציה שמזהה את האלמנט על הlocator של MyAccount ונכנסת אליו
    public void MyAccounBotton(){
        driver.findElement(MyAccountLocator).click();
    }

    //פונקציה שמכניסה מייל
    public void enterEmail(String email){
        driver.findElement(EmailLocator).sendKeys(email);
    }

    //פונקציה שמכניסה סיסמה
    public void enterPassword(String password){
        driver.findElement(PasswordLocator).sendKeys(password);
    }

    //
    public void SignInLocatorBotton(){
        driver.findElement(MyAccountLocator).click();
    }
}
