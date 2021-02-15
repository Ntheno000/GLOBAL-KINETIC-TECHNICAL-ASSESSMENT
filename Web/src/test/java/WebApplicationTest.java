import org.openqa.selenium.*;
//import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;



public class WebApplicationTest {
    static String url = "https://demoqa.com/";
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","Web/src/main/resources/Driver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        options.setExperimentalOption("useAutomationExtension",false);
        driver = new ChromeDriver(options);

        driver.get(url);
        driver.manage().window().maximize();

        Thread.sleep(8000);


//        WebElement element = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div/div[2]/svg/path"));
        WebElement element = driver.findElement(By.xpath(DefineVariable.elementXpath));
        JavaScriptMethod(element);
        Reporter.log("Element clicked");


//
        driver.findElement(By.xpath(DefineVariable.textBox)).click();
        Reporter.log("TextBox clicked");
        driver.findElement(By.id(DefineVariable.username)).clear();
        driver.findElement(By.id(DefineVariable.username)).sendKeys("John");
        driver.findElement(By.id(DefineVariable.userEmail)).clear();
        driver.findElement(By.id(DefineVariable.userEmail)).sendKeys("Ntho000@gmail.com");
        driver.findElement(By.id(DefineVariable.currentAddress)).clear();
        driver.findElement(By.id(DefineVariable.currentAddress)).sendKeys("Testing");
        driver.findElement(By.id(DefineVariable.permanentAddress)).clear();
        driver.findElement(By.id(DefineVariable.permanentAddress)).sendKeys("Test");
        Reporter.log("Values entered");
        driver.findElement(By.id(DefineVariable.permanentAddress)).sendKeys(Keys.TAB);

        driver.findElement(By.id(DefineVariable.submit)).sendKeys(Keys.ENTER);   // Please note that the Submit button is temporarily not working from the website

        driver.quit();


    }

    public static void JavaScriptMethod(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);

    }
}
