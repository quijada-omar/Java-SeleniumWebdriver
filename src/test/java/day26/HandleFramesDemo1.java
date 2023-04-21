package day26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFramesDemo1 {
	public static void main(String[] args) {
		
		
		WebDriver d = new ChromeDriver();
		d.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		d.manage().window().maximize();
		
		d.switchTo().frame("packageListFrame");		
		d.findElement(By.linkText("org.openqa.selenium")).click();  // Frame 1
		d.switchTo().defaultContent();							// Switch back to page
		
		d.switchTo().frame("packageFrame");
		d.findElement(By.linkText("WebDriver")).click(); 			// Frame 2 
		d.switchTo().defaultContent();
		
		d.switchTo().frame("classFrame");  							// Frame 3 
		d.findElement(By.xpath("//div[@class='topNav']//a[normalize-space()='Overview']")).click();
		d.switchTo().defaultContent();
		
	}
}
