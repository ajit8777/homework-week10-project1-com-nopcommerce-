package nopcommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.time.Duration;

/** Project-1 - ProjectName : com-nopcommerce
 BaseUrl = https://demo.nopcommerce.com/
 1. Setup Chrome browser.
 2. Open URL.
 3. Print the title of the page.
 4. Print the current url.
 5. Print the page source.
 6. Navigate to Url.
 “https://demo.nopcommerce.com/login?returnUrl=%2F”
 7. Print the current url.
 8. Navigate back to the home page.
 9. Navigate to the login page.
 10. Print the current url.
 11. Refresh the page.
 12. Enter the email to email field.
 13. Enter the password to password field.
 14. Click on Login Button.
 15. Close the browser.
 */

public class NopcommerceDemo {
    static String browser = "Chrome";
    static String baseUrl = " https://demo.nopcommerce.com/";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        // 1. Setup Multiple browser.
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("Internet Explorer")) {
            driver = new InternetExplorerDriver();
        } else {
            System.out.println("Wrong browser name");
        }

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //Implicitly wait time
        driver.manage().window().maximize(); // Maximise the window

        // 2. Open URL.
        driver.get(baseUrl);

        // 3. Print the title of the page.
        System.out.println(driver.getTitle());

        // 4. Print the current url.
        System.out.println("The current Url is : " + driver.getCurrentUrl());

        // 5. Print the page source.
        System.out.println("The page source is : " + driver.getPageSource());

        // Navigate to Url. //“https://demo.nopcommerce.com/login?returnUrl=%2F”
        String loginUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
        driver.navigate().to(loginUrl);

        // 7. Print the current url.
        System.out.println("The current url is : " + driver.getCurrentUrl());

        //8. Navigate back to the home page.
        driver.navigate().back();

        // 9. Navigate to the login page.
        driver.navigate().forward();

        // 10. Print the current url.
        System.out.println("The current url is : " + driver.getCurrentUrl());

        // 11. Refresh the page.
        driver.navigate().refresh();

        // 12. Enter the email to email field.
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("ajit_patel1234@yahoo.com");

        //13. Enter the password to password field.
        WebElement passwordField = driver.findElement(By.name("Password"));
        passwordField.sendKeys("Ajit1234");
        Thread.sleep(3000);

        //14. Click on Login Button.
        WebElement loginClick = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
        loginClick.click();
        Thread.sleep(3000);

        //15. Close the browser.
        driver.quit();
    }
}
