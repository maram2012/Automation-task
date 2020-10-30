package tests;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends TestBase {
	
	LoginPage loginObject;
	
	@Test
	public void UserCanLoginWithValidCredentials() {
		
		loginObject = new LoginPage(driver);
		loginObject.handlingCookies();
		loginObject.userLoginWithValidCredentials("archsa@miaw.guru", "Test1234");
		//Wait until welcome message is displayed 
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(loginObject.welcomeMsg));
	}
	
	@Test
	public void UserCanNotLoginWithInvalidCredentials() {
		
		loginObject = new LoginPage(driver);
		loginObject.handlingCookies();
		loginObject.userLoginWithValidCredentials("archsa@miaw.guru", "Test1235");
		//Wait until wrong message is displayed 
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(loginObject.errorMsg));
	}
	
	@Test
	public void UserIsAbleToRestHisPassword() {
		loginObject = new LoginPage(driver);
		loginObject.handlingCookies();
		loginObject.openforgotPasswordForm();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(loginObject.forgotPasswordForm));
	}
}
