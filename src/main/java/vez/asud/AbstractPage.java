package vez.asud;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalTime;

public abstract class AbstractPage {

	protected final WebDriver driver;
	protected final WebDriverWait wait;

	public AbstractPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait  = wait; // new WebDriverWait(driver, timeoutInSeconds);
		System.out.println(this.getClass().getSimpleName() + " Created at: " + LocalTime.now());
	}

}
