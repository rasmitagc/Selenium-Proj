package projectauto1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Settingclass {
	
	public static WebDriver driver;
	
	
	public static ChromeDriver setup() {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		return driver;

		
	}
	
	@BeforeSuite
	public static void suite() {
		
		driver=setup();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		
	}
	
	@AfterSuite
	public static void aftersuite() {
		
		driver.quit();
	}

}
