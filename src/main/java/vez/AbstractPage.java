package vez;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalTime;

public abstract class AbstractPage {

	protected final WebDriver driver;
	protected final WebDriverWait wait;
	@Value("${timeoutInSeconds:180}") Integer timeoutInSeconds;

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
		wait  = new WebDriverWait(driver, timeoutInSeconds);
		System.out.println(this.getClass().getSimpleName() + " Created at: " + LocalTime.now());
	}

}
