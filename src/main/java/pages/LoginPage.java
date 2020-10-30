package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageBase {


	public LoginPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(name= "email")
	WebElement email_input;

	@FindBy(name= "password")
	WebElement password_input;

	@FindBy(name= "LoginForm|SubmitChanges")
	WebElement loginBtn;

    @FindBy(id="uc-btn-accept-banner")
    WebElement cookie;
    
    @FindBy(xpath ="//div[@class=\"rd__my-douglas-welcome__intro__subline\"]")
	public WebElement welcomeMsg; 
    
    @FindBy(xpath ="//div[@class=\"rd__global-message rd__global-message--error\"]")
	public WebElement errorMsg; 
    
    @FindBy(xpath ="//a[@data-ui-name=\"loginForm.lostPasswordLink\"]")
     WebElement forgotPassword;
    
    @FindBy(xpath ="//div[@class=\"rd__modal-content\"]")
     public WebElement forgotPasswordForm;
    
	public void userLoginWithValidCredentials(String email,String password) {

		email_input.sendKeys(email);
		password_input.sendKeys(password);
		loginBtn.click();
		
	}
	
	//Close cookie message if displayed 
	public void handlingCookies() {
		
		cookie.click();
	}
	
	public void openforgotPasswordForm() {
		
		forgotPassword.click();
	}

}
