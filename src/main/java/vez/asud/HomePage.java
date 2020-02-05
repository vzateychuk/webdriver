package vez.asud;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {

	public HomePage(WebDriver driver) {
		super(driver);

		WebDriverWait wait = new WebDriverWait(driver, 300);
		wait.until(drv -> drv.findElement(By.name("TitleBar_enter_with_login_0")) != null);
		System.out.println("-->");
	}

	public ProfilePage openProfilePage() {
		driver.findElement(By.name("TitleBar_enter_with_login_0")).click();
		return new ProfilePage(driver);
	}

}
