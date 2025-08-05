package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

//דף הבית----------------
public class HomePage {

    WebDriver driver; //מופע של דרייבר
    WebDriverWait wait;



    //constructor
    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    //locators
    By homeLocator = By.xpath("//*[@id=\"meganav-link-5\"]");
    By kitchenwareLocator= By.linkText("KITCHENWARE");
    By accessoriesLocator= By.linkText("ACCESSORIES");
    By springHomeLocator = By.xpath("//*[@id=\"multi-3-teaser-712066-4_item_0\"]/div/a/div[1]");
    By langHebDegel=By.xpath("//*[@id=\"platform_modernisation_header\"]/header/div[1]/nav/div[2]/div[6]/button");
    By hebrow=By.xpath("//*[@id=\"header-country-selector-wrapper\"]/div/div[3]/div/div[4]/div/button[1]");
    By shopNow= By.xpath("//*[@id=\"header-country-selector-wrapper\"]/div/div[3]/div/div[5]/button");
    By searchInput = By.xpath("//*[@id=\"header-big-screen-search-box\"]");
    By searchButton = By.xpath("//*[@id=\"header-search-form\"]/button/img");


    //Methods

    // לחיצה כפולה על HomeLocator
    public void doubleClickHomeButton(){
        Actions actions = new Actions(driver);// יצירת מופע של Actions
        actions.doubleClick(driver.findElement(homeLocator)).perform(); // מציאת האלמנט וביצוע לחיצה כפולה עליו
    }

    //פונקציה שלוחצת על kitchenware
    public void clickKitchenware() throws InterruptedException {
        WebElement element = driver.findElement(kitchenwareLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);// גלילה
        Thread.sleep(50);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);// לחיצה עם JavaScript (עוקפת מכשולים ויזואליים)
    }

    //פונקציה שלוחצת על accessories
    public void clickAccessories(){
        driver.findElement(accessoriesLocator).click();
    }

    //פונקציה שלוחצת על springHome
    public void clickSpringHome(){
        driver.findElement(springHomeLocator).click();
    }

    //פונקציה לשינוי שפה
    public void changeLangToHeb() throws InterruptedException {
        driver.findElement(langHebDegel).click();
        driver.findElement(hebrow).click();
        driver.findElement(shopNow).click();
    }

    //פונקציה לחיפוש מוצר בתיבת חיפוש
    public void searchForProduct(String product) {
        WebElement inputElement = driver.findElement(searchInput);
        inputElement.clear();
        inputElement.sendKeys(product);

        WebElement buttonElement = driver.findElement(searchButton);
        buttonElement.click();
    }

    }
