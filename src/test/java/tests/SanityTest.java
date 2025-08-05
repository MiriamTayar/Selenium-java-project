package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.PaymentPage;
import pages.ProductPage;
import pages.SignInPage;
import utilities.Constants;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static utilities.Constants.NEXT_URL_EN;

public class SanityTest {

    private static WebDriver driver;
    static WebDriverWait wait;


    //דוחות
    private  static ExtentReports extentReports = new ExtentReports(); //הגדרת המנוע של הדוחות
    private static ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("index.html");

    //הגדרת מופעים
    SignInPage signIntoNextPage= new SignInPage(driver);  //הגדרת מופע של ה- class
    HomePage homePage = new HomePage(driver, wait);
    ProductPage productPage = new  ProductPage(driver);
    PaymentPage paymentPage = new PaymentPage(driver);


    @BeforeClass
    public static void beforeClass() {
        System.out.println("start sanity test");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("-incognito");//לגלישה אנונימית
        driver = new ChromeDriver(options); //איתחול הדרייבר לעבוד מול דפדפן של כרום

        //    //יוצרת אובייקט מסוג WebDriverWait שמאפשר להמתיך באופן חכם עד שיטען הדף עם האובייקטים
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();//מגדיל את החלון של האתר על כל המסך
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//עבור סינכרון המהירות בין האתר לבין הקוד
        driver.get(NEXT_URL_EN);
    }

    @Test
    //מסך כניסה למערכת
    public void loginTest(){
        System.out.println("start login test");
        signIntoNextPage.MyAccounBotton();
        signIntoNextPage.enterEmail("miri987@gmail.com");
        signIntoNextPage.enterPassword("9456321");
        //signIntoNextPage.SignInLocatorBotton();
        driver.navigate().to(NEXT_URL_EN);

    }
    @Test
    //דף הבית
    public void testHomePage() throws InterruptedException {
        homePage.doubleClickHomeButton();
        Thread.sleep(4000);
        homePage.clickKitchenware();// כניסה ל kitchenware

        //ווריפיקציה שהפונקציה clickKitchenware הצליחה
        if (Constants.KITCHENWARE_TITLE.equals(driver.getTitle())) //בדיקה האם הגענו לדף המבוקש
            System.out.println("[PASS]: kitchenware title ok");
        else System.out.println("[FAIL]: kitchenware title not ok");

        //return to home page
        homePage.doubleClickHomeButton();

        homePage.clickAccessories();//כניסה ל ACCESSORIES

        //ווריפיקציה שהפונקציה clickAccessories הצליחה
        Thread.sleep(400);
        if (Constants.ACCESSORIES_TITLE.equals(driver.getTitle())) //בדיקה האם הגענו לדף המבוקש
            System.out.println("[PASS]: Accessories title ok");
        else System.out.println("[FAIL]: Accessories title not ok");

        //return to home page
        homePage.doubleClickHomeButton();

        homePage.clickSpringHome();//כניסה ל spring home

        //ווריפיקציה שהפונקציה clickAccessories הצליחה
        if (Constants.SPRING_HOME_TITLE.equals(driver.getTitle())) //בדיקה האם הגענו לדף המבוקש
            System.out.println("[PASS]: SpringHome title ok");
        else System.out.println("[FAIL]: SpringHome title not ok");

        //return to home page
        homePage.doubleClickHomeButton();

        //change language to hebrow
        homePage.changeLangToHeb();

        homePage.searchForProduct("עציצים לבית");//ביצוע חיפוש למוצר מסויים בתיבת חיפוש למעלה
        //להוסיף בדיקה האם הגעתי לעציצים לבית....

    }

    @Test
    //דף חיפוש
    public void testProjectPage() throws InterruptedException {
        productPage.doubleClickBabyLocator(); //כניסה למחלקת תינוקות
        productPage.clickFirstSteps(); //בחירת מוצר
        productPage.clickOnSpecificProduct(); //בחירת מוצר מסויים
        productPage.clickColor(); //בחירת צבע מוצר
        productPage.clickdSize(); //בחירת מידה
        productPage.addToBag();//הוספה לסל פעמיים מאותו מוצר
        productPage.CheckingShoppingBug();//בדיקת סל הקניות
        productPage.clickCheckOut();//מעבר לתשלום

        //ווריפיקציה שהפונקציות רצו והגענו לדף האחרון
        if (Constants.PAYMENT_URL.equals(driver.getCurrentUrl())) //בדיקה האם הגענו לדף המבוקש
            System.out.println("[PASS]: The functions were successful.");
        else System.out.println("[FAIL]: The functions failed.");

    }

    @Test
    public void testPaymentPage() throws InterruptedException {
        //חיפוש מוצר והוספה לעגלה על מנת שנוכל לעבור לחשבון (לא ניתן לעבור לתשלום ללא הוספת מוצר אחד לפחות:)
        homePage.searchForProduct("Cooking pot");//חיפוש מוצר
        paymentPage.choose_product(); //בחירת מוצר
        Thread.sleep(5000);
        paymentPage.addToBag(); //הוספה לעגלה
        Thread.sleep(5000);
        paymentPage.checkout(); //לחיצה על כפתור לקופה
        Thread.sleep(400);
        paymentPage.continueUsGuest(); //המשך כאורח
        paymentPage.placingAnOrder(); //ביצוע ההזמנה

        Thread.sleep(6000);
        paymentPage.debitCard(); //בחירת אופצית תשלום עם כ.אשראי
        paymentPage.numOfCard("1234 5678 9012 3456");//הזנת מספר כרטיס
        paymentPage.expiryDate("02","28");//הזנת מספר כרטיס
        paymentPage.enterSecurityCode("193");//הכנסת קוד אבטחה
        paymentPage.payNow();

        if (paymentPage.isCardNumberHintVisible())
            System.out.println("Invalid card number!!!");
    }

    @AfterClass
    public static void afterClass() throws InterruptedException {
        System.out.println("end sanity test");
        Thread.sleep(4000);
        driver.quit(); //מוריד את הדפדפן בסוף התהליך
    }
}
