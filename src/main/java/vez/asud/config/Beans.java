package vez.asud.config;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource(
        value={"classpath:env/${env:local}.properties"},
        ignoreResourceNotFound = false)
public class Beans {

    @Value("${asud.url}") private String appUrl;
    @Value("${timeoutInSeconds:180}") Integer timeoutInSeconds;

    @Bean(name="webDriverBean")
    @Description("This is a sample HelloWorld Bean")
    public WebDriver getChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("enable-automation",
                "--no-sandbox",
                "--disable-infobars",
                "--disable-dev-shm-usage",
                "--disable-browser-side-navigation",
                "--disable-gpu"); // https://stackoverflow.com/a/43840128/1689770

        WebDriver driver = new ChromeDriver(options);
        driver.get(appUrl);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return driver;
    }

    @Bean(name ="webDriverWait")
    public WebDriverWait webDriverWait(WebDriver webDriverBean) {
        return new WebDriverWait(webDriverBean, timeoutInSeconds);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
