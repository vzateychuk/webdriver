package vez;

import org.openqa.selenium.WebDriver;
import vez.asud.login.*;

import java.time.LocalTime;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getChromeDriver();
        System.out.println("Main.main. STARTED: "+ LocalTime.now());

        // open chrome with login
        LoginAsUser login = new LoginAsUser(driver);
        // login to the
        HomePage homePage = login.loginValidUser("Сидоров С. С.");
        homePage.clickTreeItemTasks();

        System.out.println("Main.main. FINISH: "+ LocalTime.now());

        Thread.currentThread().wait(60000L);

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
