package projectauto1;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class registeracc extends Settingclass {
	
	
	@Test(priority = 1)
	public static void signup() throws InterruptedException {
		
		driver.get("https://demo.nopcommerce.com/");
		driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
		WebElement radio=driver.findElement(By.xpath("//input[@id='gender-female']"));
		radio.click();
		
		driver.findElement(By.cssSelector("#FirstName")).sendKeys("Rasmita");
		driver.findElement(By.cssSelector("#LastName")).sendKeys("Chhetri");
		
		Select date =new Select(driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[3]")));
		date.selectByIndex(7);
		
		Select month= new Select(driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[2]")));
		month.selectByValue("10");
		
		Select year= new Select(driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[3]")));
		year.selectByValue("2000");
	
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("asmitakc8@gmail.com");
		driver.findElement(By.xpath("//input[@id='Company']")).sendKeys("Vividagency");
		driver.findElement(By.cssSelector("#Password")).sendKeys("hoper1@");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("hoper1@");
		driver.findElement(By.xpath("//button[@id='register-button']")).click();
		Thread.sleep(6000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
		
	}
	
	@Test(priority = 3)
	public static void login() throws InterruptedException {
		
		driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
		driver.findElement(By.xpath("//a[contains(text(),'Log in')]")).click();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("asmitakc8@gmail.com");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("hoper1@");
		driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
		//Thread.sleep(6000);
		
	}
	
	@Test(priority = 2)
	public static void loginvalid() throws InterruptedException {
		
		//driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
		driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
		driver.findElement(By.xpath("//a[contains(text(),'Log in')]")).click();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("");
		driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
		Thread.sleep(6000);
		
	}
	@Test(priority=4)
	public static void address() throws InterruptedException {
		
		
		driver.findElement(By.xpath("//body/div[6]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/a[1]")).click();
		driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[2]/a[1]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Add new')]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));	
		
		driver.findElement(By.name("Address.FirstName")).sendKeys("Anjana");
		driver.findElement(By.name("Address.LastName")).sendKeys("kc");
		driver.findElement(By.name("Address.Email")).sendKeys("anjanakc1@gmail.com");
		driver.findElement(By.name("Address.Company")).sendKeys("NBL");
		Thread.sleep(2000);
		
		//select country by drop down
		Select country=new Select(driver.findElement(By.cssSelector("#Address_CountryId")));
		country.selectByVisibleText("Albania");
		
		driver.findElement(By.xpath("//input[@id='Address_City']")).sendKeys("Kathmandu");
		driver.findElement(By.cssSelector("#Address_Address1")).sendKeys("Baneshowr");
		driver.findElement(By.cssSelector("#Address_Address2")).sendKeys("MinBhawan");
		driver.findElement(By.name("Address.ZipPostalCode")).sendKeys("44700");
		driver.findElement(By.xpath("//input[@id='Address_PhoneNumber']")).sendKeys("93651287323");
		driver.findElement(By.xpath("//input[@id='Address_FaxNumber']")).sendKeys("78594");
		driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
		Thread.sleep(3000);
		
        wait.until(ExpectedConditions.alertIsPresent());

        //handling alert
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("AlertText: " + alertText);
        alert.accept();
		
		Thread.sleep(3000);
		
		
	}
	
	@Test(priority=5)
	public static void editaddress() throws InterruptedException {
		
		driver.findElement(By.xpath("//button[contains(text(),'Edit')]")).click();       //edit name of the added address
		WebElement newtext=driver.findElement(By.xpath("//input[@id='Address_FirstName']"));
		newtext.clear();																		//clear text
		newtext.sendKeys("manita");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
		
		
	}
	@Test(priority=6)
	public static void deleteaddress() throws InterruptedException {
		
		driver.findElement(By.xpath("//button[contains(text(),'Delete')]")).click();
		
		Alert alert=driver.switchTo().alert();				//test alert and popups
		String altinfo=alert.getText();
		System.out.println("Alert Text:+Alert class");
		alert.accept();
		Thread.sleep(5000);
		address();
	}
	
	
	@Test(priority=7)
	public static void searchitem() throws InterruptedException {
		
		
		driver.findElement(By.xpath("//body/div[6]/div[1]/div[2]/div[1]/a[1]/img[1]")).click();
		driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("iphone");
		driver.findElement(By.xpath("//button[contains(text(),'Search')]")).click();
		driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[2]/button[1]")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=8)
	public static void advancesearch() throws InterruptedException {
		
		driver.get("https://demo.nopcommerce.com/");
		driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("computer");
		driver.findElement(By.xpath("//button[contains(text(),'Search')]")).click();
		driver.findElement(By.cssSelector("#advs")).click();
		
		Select category= new Select(driver.findElement(By.xpath("//select[@id='cid']")));
		category.selectByIndex(2);
		
		driver.findElement(By.cssSelector("#isc")).click();
		
		Select manuf= new Select(driver.findElement(By.xpath("//select[@id='mid']")));
		manuf.selectByVisibleText("All");
		
		driver.findElement(By.cssSelector("#sid")).click();
		
		driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[2]/button[1]")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority = 9)
	public static void title1() throws InterruptedException {
		
		driver.findElement(By.xpath("//body")).click();
		driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/a[1]")).click();
		driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/h2[1]/a[1]")).click();
		Thread.sleep(3000);
		
	}
	
	@Test(priority = 10)
	public static void title2() throws InterruptedException {
		
		driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[4]/a[1]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'If You Wait (donation)')]")).click();
		Thread.sleep(3000);
	}
	
	
	
}
