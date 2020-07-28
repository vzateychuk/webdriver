package vez.asud.findoc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import vez.asud.AbstractPage;

public class OpenDoc extends AbstractPage {

	public OpenDoc(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		driver.switchTo().defaultContent();
		wait.until( ExpectedConditions.visibilityOfElementLocated(By.id("MainEx_titlebar_0")) );
	}

	/**
	 * find and open document
	 *
	 * @param documentId
	 */
	public void findAndOpenDocument(String documentId) {
		// Open find page
		System.out.println("OpenDoc.findAndOpenDocument: " + documentId);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("MainEx_titlebar_0");

		By searchButtonBy = By.name("TitleBar_search_0");
		wait.until(ExpectedConditions.visibilityOfElementLocated( searchButtonBy ));
		driver.findElement( searchButtonBy ).click();

		// находим и вводим documentId и нажимаем на кнопку
		driver.switchTo().defaultContent();
		driver.switchTo().frame("MainEx_view_0");
		driver.switchTo().frame("Classic_workarea_0");
		driver.switchTo().frame("Form_content_0");
		By byTagFrame = By.tagName("frame");
		wait.until(ExpectedConditions.visibilityOfElementLocated( byTagFrame ));
		driver.switchTo().frame( driver.findElement( byTagFrame ) );
		By inputSearchById = By.name("advsearchcontainer_contents_r_object_id_0");
		wait.until(ExpectedConditions.visibilityOfElementLocated( inputSearchById ));
		driver.findElement( inputSearchById ).sendKeys(documentId);

		By runSearchButtonBy = By.name("advsearchcontainer_contents_ok_0");
		wait.until(ExpectedConditions.visibilityOfElementLocated( runSearchButtonBy ));
		driver.findElement( runSearchButtonBy ).click();

		By iconBy = By.name("documents_registered_search_results_propact_0");
		wait.until(ExpectedConditions.visibilityOfElementLocated( iconBy ));
		System.out.println("OpenDoc.findAndOpenDocument: found document icon");
		driver.findElement( iconBy ).click();

	}
}
