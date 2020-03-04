package vez.asud.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import vez.asud.AbstractPage;

class WelcomePage extends AbstractPage {

	WelcomePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);

		wait.until(o -> !o.findElements(By.id("MainEx_titlebar_0")).isEmpty());
	}

	OrgStructureViewerPage openProfilePage() {
		driver.switchTo().frame("MainEx_titlebar_0");
		driver.findElement(By.name("TitleBar_enter_with_login_0")).click();
		driver.switchTo().parentFrame();
		return new OrgStructureViewerPage(driver, wait);
	}

}
