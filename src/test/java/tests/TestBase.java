/*Test Base class to start the driver  */

package tests;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class TestBase {

	public static WebDriver driver;

	@BeforeMethod
	public void startDriver() {

		System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
		driver.navigate().to("https://www.douglas.de/mydouglas/login");

	}
	
	//Print failed when the test case is failing 
	@AfterMethod
	public void screenshotOnFailure(ITestResult result) {
		if(result.getStatus()== ITestResult.FAILURE){
			System.out.println("Failed!");

		}
	}

	@AfterMethod
	public void stopDriver()
	{
		driver.quit();
	}

}
