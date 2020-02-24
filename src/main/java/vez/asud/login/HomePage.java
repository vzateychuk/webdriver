package vez.asud.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import vez.AbstractPage;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class HomePage extends AbstractPage {

	HomePage(WebDriver driver) {
		super(driver);
		wait.until(o -> !o.findElements(By.id("MainEx_view_0")).isEmpty());
	}

	public void clickTreeItemTasks() {
		System.out.println("HomePage.clickTreeItemTasks, Starting, time: " + LocalTime.now());
		// goto TreeView frame and click on Tasks button
		driver.switchTo().frame("MainEx_view_0");
		wait.until(o -> !o.findElements(By.id("Classic_browser_0")).isEmpty());
		driver.switchTo().frame("Classic_browser_0");

		System.out.println("HomePage.clickTreeItemTasks, switched to Classic_browser_0, time: " + LocalTime.now());

		wait.until(o -> !o.findElements(By.id("BrowserTreeWithArchive_0")).isEmpty());

		System.out.println("HomePage.clickTreeItemTasks, found BrowserTreeWithArchive_0, time: " + LocalTime.now());

		By byXpathTasks = By.xpath("//div[contains(@id, '._ROOT.MRSK_CNT.task_list')]/nobr/a[2]");
		wait.until(o -> !o.findElements(byXpathTasks).isEmpty());

		System.out.println("HomePage.clickTreeItemTasks, found _ROOT.MRSK_CNT.task_list, clicking, time: " + LocalTime.now());

		driver.findElement(byXpathTasks).click();

		// wait until the frame will be loaded
		driver.switchTo().defaultContent();
		driver.switchTo().frame("MainEx_view_0");
		//
		wait.until(o -> !o.findElements(By.id("Classic_workarea_0")).isEmpty());
		driver.switchTo().frame("Classic_workarea_0");
		System.out.println("HomePage.clickTreeItemTasks, Classic_workarea_0 loaded: time: " + LocalTime.now());
		//
		wait.until(o -> !o.findElements(By.id("Form_content_0")).isEmpty());
		driver.switchTo().frame("Form_content_0");
		System.out.println("HomePage.clickTreeItemTasks, Form_content_0 loaded: time: " + LocalTime.now());
		//
		wait.until(o->!o.findElements(By.id("TasksDocumentList_0") ).isEmpty());
		System.out.println("HomePage.clickTreeItemTasks, finished: time: " + LocalTime.now());
	}

}
