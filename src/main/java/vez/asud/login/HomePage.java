package vez.asud.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import vez.AbstractPage;

import java.time.LocalTime;

public class HomePage extends AbstractPage {

	HomePage(WebDriver driver) {
		super(driver);
		wait.until( ExpectedConditions.visibilityOfElementLocated(By.id("MainEx_view_0")) );
	}

	public void clickTreeItemTasks() {
		System.out.println("HomePage.clickTreeItemTasks, Starting, time: " + LocalTime.now());
		driver.switchTo().frame("MainEx_view_0");
		// wait until the Form_content_0 will be fully loaded
		driver.switchTo().frame("Classic_workarea_0");
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Form_content_0")));
		driver.switchTo().frame("Form_content_0");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("HomeCabinet_0")));

		// goto the tree and click on the taskTreeItem
		driver.switchTo().defaultContent();
		driver.switchTo().frame("MainEx_view_0");
		driver.switchTo().frame("Classic_browser_0");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BrowserTreeWithArchive_0")));
		By byXpathTasks = By.xpath("//div[contains(@id, '._ROOT.MRSK_CNT.task_list')]/nobr/a[2]");
		WebElement taskTreeItem = wait.until(ExpectedConditions.visibilityOfElementLocated( byXpathTasks ));
		taskTreeItem.click();

		// Wait until TasksDocumentList is visible
		driver.switchTo().defaultContent();
		driver.switchTo().frame("MainEx_view_0");
		driver.switchTo().frame("Classic_workarea_0");
		driver.switchTo().frame("Form_content_0");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("TasksDocumentList_object_list_grid_0") ));
		System.out.println("HomePage, 'TasksDocumentList_object_list_grid_0' finished: time: " + LocalTime.now());
	}

}
