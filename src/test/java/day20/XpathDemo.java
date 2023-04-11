package day20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class XpathDemo {
	public static void main(String[] args) {

		WebDriver browser = new FirefoxDriver();
		browser.get("https://demo.opencart.com");
		browser.manage().window().maximize();
//		String productName = browser.findElement(By.xpath("//a[text()='MacBook']")).getText();
//		String productName = browser.findElement(By.xpath("/html/body/main/div[2]/div/div/div[2]/div[1]/form/div/div[2]/div[1]/h4/a")).getText();
//		System.out.println(productName);
		
	}
}
