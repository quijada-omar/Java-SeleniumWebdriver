package day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Assignment {


	public static void main(String[] args) {
		//		 1) Launch browser
		WebDriver driver = new FirefoxDriver();
		//		2) Open URL
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		//		Provide username - admin@yourstore.com
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys("admin@yourstore.com");
		//		Provide password - admin
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("admin");
		// 		Click on login button
		driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")).click();
		// 		Verify title of the dashboard page
		//		Dashboard / nopCommerce administration
		String expectedTitle = "Dashboard / nopCommerce administration";
		String actualTitle = driver.getTitle();
		if(expectedTitle.equals(actualTitle))
			System.out.println("Test passed");
		else
			System.out.println("Test failed");
		

	}
}
