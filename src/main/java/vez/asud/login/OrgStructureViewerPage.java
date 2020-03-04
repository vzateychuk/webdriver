package vez.asud.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import vez.asud.AbstractPage;

class OrgStructureViewerPage extends AbstractPage {

	OrgStructureViewerPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		wait.until(o -> !o.findElements(By.id("MainEx_titlebar_0")).isEmpty());
	}

	HomePage loginAs(String userName) {
		// wait until branches are visible
		driver.switchTo().frame("MainEx_titlebar_0");
		driver.switchTo().frame(0);
		// select branch
		Select dropdown = new Select( driver.findElement(By.name("OrgStructureViewer_branch_ddl_control_0")) );
		dropdown.selectByVisibleText(" Тестовый филиал");

		// Choose test-user by name
		wait.until(o -> !o.findElements(By.xpath("//*[@title='Сидоров С. С.']")).isEmpty());
		driver.findElements(By.xpath("//*[@title='Сидоров С. С.']")).get(0).click();

		// click login
		wait.until(o -> !o.findElements(By.name("OrgStructureViewer_Link_5")).isEmpty());
		driver.findElements(By.name("OrgStructureViewer_Button_1")).get(0).click();

		return new HomePage(driver, wait);
	}
}
