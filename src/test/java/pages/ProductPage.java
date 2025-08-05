package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    WebDriver driver;


    //constructor
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    By babyLocator = By.xpath("//*[@id=\"meganav-link-3\"]/div");
    By firstStepsLoctor = By.xpath("//*[@id=\"multi-4-teaser-904390-4_item_0\"]/div/a/div[1]/img");
    By specificProduct = By.xpath("//*[@id=\"platform_modernisation_product_summary_447419\"]/div/div[1]/div[1]/div/div/div[1]/a/img");
    By pinkButton = By.cssSelector("button[aria-label='Pink available']");
    By addToBagButton = By.cssSelector(".pdp-css-xwot90");
    By shoppingBugButton = By.xpath("//*[@id=\"platform_modernisation_header\"]/header/div[1]/nav/div[2]/div[4]/div[2]/a/div");
    By viowBagButtom = By.xpath("//*[@id=\"platform_modernisation_header\"]/header/div[1]/nav/div[2]/div[4]/div[2]/div/div/div[2]/div[2]/div/div/div[3]/div[1]/a");

    By checkOutButton = By.xpath("//*[@id=\"pri\"]/div[1]/div[2]/div[1]/div[1]/div[5]/button");

    //Methods

    // לחיצה כפולה על babyLocator
    public void doubleClickBabyLocator(){
        Actions actions = new Actions(driver);// יצירת מופע של Actions
        actions.doubleClick(driver.findElement(babyLocator)).perform(); // מציאת האלמנט וביצוע לחיצה כפולה עליו
    }

    //גלילה ולחיצה על first steps
    public void clickFirstSteps() throws InterruptedException {
        WebElement element = driver.findElement(firstStepsLoctor);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);// גלילה
        Thread.sleep(50);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);// לחיצה עם JavaScript (עוקפת מכשולים ויזואליים)
    }

    // בחירת מוצר מסויים
    public void clickOnSpecificProduct() throws InterruptedException {
        driver.findElement(specificProduct).click();
        driver.findElement(pinkButton).click();
    }

    //בחירת צבע במוצר
    public void clickColor() throws InterruptedException {
        driver.findElement(pinkButton).click();
    }

    //בחירת מידה במוצר
    public void clickdSize() throws InterruptedException {
        //לחיצה על הרשימה נפתחת
        driver.findElement(By.xpath("//div[@role='combobox' and text()='Choose Size']")).click();

        //המתנה שהרשימה תפתח
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@role='listbox']")));

        WebElement item = driver.findElement(By.xpath("//*[@id=\":R4lakqijlaqjdemd6:\"]/li[1]"));//בחירת המידה
        item.click();
    }

    //הוספה לסל
    public void addToBag() throws InterruptedException {
        driver.findElement(addToBagButton).click(); //הוספה פעם אחת לסל
        Thread.sleep(4000);
        driver.findElement(addToBagButton).click(); // הוספת פריט נוסף מאותו מוצר
    }

    //בדיקת סל הקניות
    public void CheckingShoppingBug() throws InterruptedException {
        driver.findElement(shoppingBugButton).click();
        Thread.sleep(400);
        driver.findElement(viowBagButtom).click();
    }

    //לחיצה על כפתור לקופה
    public void clickCheckOut(){
        driver.findElement(checkOutButton).click();

    }

}
