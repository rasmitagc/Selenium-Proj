package projectauto1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class cartpage extends registeracc{
	
	@Test(priority=11)
	public static void addtocart() throws InterruptedException {
		
		driver.get("https://demo.nopcommerce.com/");
		driver.findElement(By.xpath("//body")).click();
		driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/a[1]")).click();
		driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/h2[1]/a[1]")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Nike Floral Roshe Customized Running Shoes')]")).click();
		
		Select size= new Select(driver.findElement(By.cssSelector("#product_attribute_6")));
		size.selectByIndex(3);
		
		
		Select color= new Select(driver.findElement(By.cssSelector("#product_attribute_7")));
		color.selectByIndex(1);
		
		driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[6]/dl[1]/dd[3]/ul[1]/li[2]/label[1]/span[1]/span[1]")).click();
		
		WebElement quantity=driver.findElement(By.cssSelector("#product_enteredQuantity_24"));
		quantity.clear();
		quantity.sendKeys("2");
		
		
		WebElement element = driver.findElement(By.id("add-to-cart-button-24"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();

		//driver.findElement(By.cssSelector("#add-to-cart-button-24")).click();
		Thread.sleep(5000);
	
	}
	

	@Test(priority = 12)
	public static void viewcar() throws InterruptedException {
		
		driver.get("https://demo.nopcommerce.com/cart");
		driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]")).click();
		Thread.sleep(3000);
	}
	
	
	@Test(priority=13)
	public static void removefromcar() throws InterruptedException {
			
			
		driver.findElement(By.xpath("//tbody/tr[1]/td[7]/button[1]")).click();
			Thread.sleep(6000);
			
	}
	
	@Test(priority=14)
	public static void checkout() throws InterruptedException {
		
		driver.get("https://demo.nopcommerce.com/jewelry");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[2]/button[1]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
		driver.findElement(By.xpath("//button[@id='checkout']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[2]")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]")).click();
		driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]")).click();
		driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
		Thread.sleep(2000);
	}

}
