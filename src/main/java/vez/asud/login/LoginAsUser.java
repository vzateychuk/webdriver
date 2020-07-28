package vez.asud.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import vez.asud.AbstractPage;

public class LoginAsUser extends AbstractPage {

	public LoginAsUser(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	/**
	 * Login as valid user
	 *
	 * @param userName
	 */
	public void loginValidUser(String userName) {
		// sign-in
		SignInPage signInPage = new SignInPage(driver, wait);
		WelcomePage welcomePage = signInPage.loginValidUser("dmowner", "dmowner");
		// choose profile
		OrgStructureViewerPage profilePage = welcomePage.openProfilePage();
		HomePage homePage = profilePage.loginAs(userName);
        homePage.clickTreeItemTasks();
	}
}
