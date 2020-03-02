package vez.asud.login;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class LoginAsUser {

	final WebDriver driver;

	public LoginAsUser(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Login as valid user
	 *
	 * @param userName
	 * @return HomePage object
	 */
	public HomePage loginValidUser(String userName) {
		// driver.get("http://10.249.99.59:28083/mrsk_center2/component/main");
		driver.get("http://as-center.devel:28080/asud/component/main");
		// swallow the alert
		Alert alt = driver.switchTo().alert();
		alt.accept();
		// sign-in
		SignInPage signInPage = new SignInPage(driver);
		WelcomePage welcomePage = signInPage.loginValidUser("dmowner", "dmowner");
		// choose profile
		OrgStructureViewerPage profilePage = welcomePage.openProfilePage();
		HomePage homePage = profilePage.loginAs(userName);
		return homePage;
	}
}
