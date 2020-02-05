package vez;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import vez.asud.ProfilePage;
import vez.asud.HomePage;
import vez.asud.SignInPage;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getChromeDriver();

        // open chrome with login
        driver.get("http://localhost:8080/asud/component/main");

        // swallow the alert
        Alert alt = driver.switchTo().alert();
        alt.accept();

        // login
        SignInPage signInPage = new SignInPage(driver);
        HomePage homePage = signInPage.loginValidUser("dmowner", "dmowner");

        // choose profile
        ProfilePage profilePage = homePage.openProfilePage();
        profilePage.chooseProfile("Сидоров С. С.");

        driver.quit();

        // Assert.assertNotNull("Unsuccessful attempt", driver.findElement(By.name("OrgStructureViewer_branch_ddl_control_0")));
/*
        WebElement login = getWebElementById("LoginUsername");
        login.sendKeys("dmowner");
        WebElement pwd = getWebElementById("Login_password_0");
        pwd.sendKeys("dmowner");
        pwd.sendKeys(Keys.ENTER);

        // wait and login as
        By byLoginAs = By.name("TitleBar_enter_with_login_0");
        wait.until(drv -> drv.findElement(byLoginAs) != null);
        driver.findElement(byLoginAs).click();

        wait.until(o -> !o.findElements(By.xpath("//*[@id='thumbnail']")).isEmpty());

        driver.findElement(By.xpath("(//*[@id='thumbnail'])[1]")).click();
        By byPlayerClassName = By.className("html5-video-container");
        wait.until(o -> o.findElement(byPlayerClassName) != null);

        System.out.println("Pause Video");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(byPlayerClassName));
        wait.until(o -> o.findElement(By.xpath("//*[contains(@class, 'ytp-play-button')]")) != null);
        driver.findElement(By.xpath("//*[contains(@class, 'ytp-play-button')]")).click();
*/

    }

}
