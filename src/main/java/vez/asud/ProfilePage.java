package vez.asud;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends AbstractPage{

	ProfilePage(WebDriver driver) {
		super(driver);

		if ( !"Система электронного документооборота ПАО \"МРСК Центра\"".equals( driver.getTitle() ) ) {
			throw new IllegalStateException("This is not SignIn page: " + driver.getCurrentUrl());
		}

		WebDriverWait wait = new WebDriverWait(driver, 600);
		wait.until(o -> !o.findElements(By.xpath("//*[@class='webofficePageHeader']")).isEmpty());

		System.out.println("ChooseProfilePage.ChooseProfilePage. We are here!!!");
	}

	public void chooseProfile(String profileName) {
		System.out.println("ProfilePage.chooseProfile. Invoked for: '" + profileName + "'");
	}
}
