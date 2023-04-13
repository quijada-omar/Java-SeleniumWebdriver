package day22;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetMethods {
	public static void main(String[] args) {

		WebDriver d = new FirefoxDriver();

		d.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		d.manage().window().maximize();
		String title = d.getTitle();
		System.out.println("Title of the page: " + title);
	/*
		System.out.println("Current URL: " + d.getCurrentUrl());
		System.out.println("Page source:\n"+d.getPageSource());
		System.out.println(d.getPageSource().contains("html"));	*/

		//		System.out.println("Window handle object: "+d.getWindowHandle());
		try {
		Thread.sleep(6000);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		d.findElement(By.linkText("OrangeHRM, Inc")).click();	// Open a browser window.
		
		Set<String> windowHandles = d.getWindowHandles();
		
		for(String winid : windowHandles) {
			System.out.println(winid);
		}
		
		
		
		d.quit();
	}
}
