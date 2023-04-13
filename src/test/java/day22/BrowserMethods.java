package day22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserMethods {
	
	public static void main(String[] args) {
		
		WebDriver d = new FirefoxDriver();
		d.get("https://opensource-demo.orangehrmlive.com/");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		d.findElement(By.linkText("OrangeHRM, Inc")).click();
		
		d.manage().window().maximize();
//		d.close();
		d.quit();
	}

}
