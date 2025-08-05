package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Year;
import java.util.List;

public class PaymentPage {

    WebDriver driver;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    By choosing_specific_product = By.xpath("//*[@id=\"platform_modernisation_product_summary_763408\"]/div/div[1]/div[1]/a/img");
    By add_to_bag = By.xpath("//*[@id=\":R16cjlaqjdemd6:\"]");
    By checkout_button = By.xpath("//a[text()='Checkout']");
    By continue_us_guest_button = By.xpath("//*[@id=\"Next\"]/div/a/div");
    By drop_down_title = By.id("Title");
    By first_name_locator = By.xpath("//*[@id=\"FirstName\"]");
    By last_name_locator = By.xpath("//*[@id=\"LastName\"]");
    By email_locator = By.xpath("//*[@id=\"Email\"]");
    By phone_number_locator = By.xpath("//*[@id=\"PhoneNumber\"]"); //טלפון
    By apartment_locator = By.xpath("//*[@id=\"AddressLine1\"]"); //דירה
    By house_Number_and_street_name_locator = By.xpath("//*[@id=\"AddressLine2\"]"); //מספר בית ושם רחוב
    By town_or_city_locator = By.xpath("//*[@id=\"AddressLine4\"]"); //עיריה או עיר
    By state_or_province_dropdown = By.xpath("//*[@id=\"AddressLine5\"]"); //מדינה או מחוז
    By zip_code = By.xpath("//*[@id=\"AddressLine6\"]"); //מיקוד- 7 ספרות
    By continue_button = By.id("SignupButton");
    By debit_card = By.id("WorldPayIframe-label");
    By card_number_locator = By.id("cardNumber"); //מס' כרטיס אשראי
    By expiry_date_month = By.xpath("//*[@id=\"expiryMonth\"]"); //תאריך תפוגה- חודש
    By expiry_date_year = By.xpath("//*[@id=\"expiryYear\"]"); //תאריך תפוגה- שנה
    By security_code = By.id("securityCode"); //קוד אבטחה
    By pay_now_button = By.id("submitButton"); //שלם כעת
    By cardNumberHintLocator = By.id("cardNumber-hint"); //עבור בדיקה האם מספר הכרטיס שהוזן נכון


    //Methods

    //בחירת מוצר מסוים כדי שנוכל להיכנס לתשלום
    public void choose_product(){
        driver.findElement(choosing_specific_product).click();
    }
    //הוספה לעגלה
    public void addToBag(){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("header-content-banner")));
        driver.findElement(add_to_bag).click();
    }
    //לחיצה על כפתור לקופה
    public void checkout(){
        driver.findElement(checkout_button).click();
    }
    // לחיצה על המשך כאורח
    public void continueUsGuest(){
        driver.findElement(continue_us_guest_button).click();
    }


    //מילוי השדות הנדרשים לביצוע ההזמנה
    //מילוי השדות הנדרשים נעשה בפונקציה אחת והפרטים הוכנסו ישירות כיון שאין עינין בזה כרגע אלא על מנת שנוכל להיכנס לתשלום...
    public void placingAnOrder() throws InterruptedException {

        //מילוי שדה Title
        WebElement dropdown = driver.findElement(drop_down_title); // מחפש את ה-select
        Select select = new Select(dropdown); // יוצר אובייקט Select

        select.selectByVisibleText("Mrs"); // בחירת האפשרות "Mrs"


        driver.findElement(first_name_locator).sendKeys("Miri");//שם פרטי
        driver.findElement(last_name_locator).sendKeys("Ram");//משפחה
        driver.findElement(email_locator).sendKeys("wqa8561@gmail.com");//מייל
        driver.findElement(phone_number_locator).sendKeys("0556874132");// טלפון
        driver.findElement(apartment_locator).sendKeys("5");//דירה
        driver.findElement(house_Number_and_street_name_locator).sendKeys("Lily 1");//מספר בית ושם רחוב
        //גלילה להמשך העמוד
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(400);
        driver.findElement(town_or_city_locator).sendKeys("Jerusalem");//עיריה או עיר
        //מדינה או מחוז
        WebElement dropdown2 = driver.findElement(state_or_province_dropdown); // מחפש את ה-select
        Select select2 = new Select(dropdown2); // יוצר אובייקט Select
        select2.selectByVisibleText("Yerushalayim"); // בחירת האפשרות "Yerushalayim"
        driver.findElement(zip_code).sendKeys("1254698");//מיקוד

        driver.findElement(continue_button).click();
        Thread.sleep(4000);
    }

    //בחירת שיטת תשלום בכרטיס אשראי
    public void debitCard(){
        driver.findElement(debit_card).click();
    }

    //הזנת מספר כרטיס
    public void numOfCard(String cardNumber){
        driver.findElement(card_number_locator).sendKeys(cardNumber);
    }

    //הזנת תאריך תפוגה
    public void expiryDate(String month, String year){
        driver.findElement(expiry_date_month).sendKeys(month);
        driver.findElement(expiry_date_year).sendKeys(year);
    }
    //הזנת קוד אבטחה
    public void enterSecurityCode(String code){
        driver.findElement(security_code).sendKeys(code);
    }
    //לחיצה על כפתור שלם כעת
    public void payNow(){
        driver.findElement(pay_now_button).click();
    }
    //בדיקה האם מספר האשראי תקין
    public boolean isCardNumberHintVisible() {
        List<WebElement> elements = driver.findElements(cardNumberHintLocator);
        return !elements.isEmpty() && elements.get(0).isDisplayed();
    }
}
