package vez.asud;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

	final WebDriver driver;

	AbstractPage(WebDriver driver) {
		this.driver = driver;
		System.out.println(this.getClass().getSimpleName() + " Created.");
	}

}
