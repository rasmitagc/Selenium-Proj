package projectauto1;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Header extends Settingclass{
	
	@Test
	public static void title1() {
		
		driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]")).click();
		//driver.findElement(By.xpath(""));
		//driver.findElement(By.xpath(""));
		//driver.findElement(By.xpath(""));
		//driver.findElement(By.xpath(""));
		
		
	}
	

}
