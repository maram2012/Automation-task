package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/*Factory class to make using Page Objects simpler and easier	
(this) mean the current class 
1-(driver) The driver that will be used to look up the elements
2-(page) The object with WebElement fields that 
should be proxied. */

public class PageBase {
	protected WebDriver driver;

	
	public PageBase(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
}
