package day18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocatorsDemo1 {
	public static void main(String[] args) {
		
		WebDriver browser = new FirefoxDriver();
		
//		Open application	
		browser.get("http://automationpractice.pl/index.php");
//		Get URL
		browser.manage().window().maximize();
//		Search bar - ID
		browser.findElement(By.id("search_query_top")).sendKeys("T-shirts");
//		Search button - NAME
		browser.findElement(By.name("submit_search")).click();
//		- LinkText - PartialLinkText. THEY'RE NOT ATTRIBUTES OF ELEMENTS.
//		browser.findElement(By.linkText("Blouse")).click();  // Complete value of link text
		browser.findElement(By.partialLinkText("Faded Short Sleeve")).click(); // Partial text of the linktext. DO NOT USE BECAUSE CAN HAVE MULTIPLE ELEMENTS.
		
		
//		Close
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		browser.quit();
		
		
		
		
		
		
	}
}
