package vez.asud.login;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import vez.AbstractPage;

class SignInPage  extends AbstractPage {

	SignInPage(WebDriver driver) {
		super(driver);

		if ( !"Вход в АСУД".equals( driver.getTitle() ) ) {
			throw new IllegalStateException("This is not SignIn page: " + driver.getCurrentUrl());
		}

		wait.until(drv -> drv.findElement(By.name("Login_username_0")) != null);
	}

	/**
	 * Login as valid user
	 *
	 * @param userName
	 * @param password
	 * @return HomePage object
	 */
	WelcomePage loginValidUser(String userName, String password) {
		WebElement loginInput = driver.findElement(By.name("Login_username_0"));
		loginInput.sendKeys(userName);

		WebElement pwdInput = driver.findElement(By.name("Login_password_0"));
		pwdInput.sendKeys(password);
		pwdInput.sendKeys(Keys.ENTER);

		return new WelcomePage(driver);
	}

}
