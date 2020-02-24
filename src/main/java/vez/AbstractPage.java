package vez;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalTime;

public abstract class AbstractPage {

	protected final WebDriver driver;
	protected final WebDriverWait wait;

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
		wait  = new WebDriverWait(driver, 1800);
		System.out.println(this.getClass().getSimpleName() + " Created at: " + LocalTime.now());
	}

}
