package vez;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    public static WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "./lib/chromedriver");
        WebDriver driver = new ChromeDriver();
        // driver.manage().window().fullscreen();
        return driver;
    }
}
