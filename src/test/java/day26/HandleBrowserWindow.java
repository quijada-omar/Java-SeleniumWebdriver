package day26;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandleBrowserWindow {
	public static void main(String[] args) {
		WebDriver wd = new FirefoxDriver();
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//		getWindowHandle - returns id of the currently single window (in which driver is focused)
		//		getWindowHandles - returns ids of multiple windows
		//		driver.switchTo().window(windowId)
		wd.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		wd.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		//		Capture ids of browser windows.
		Set<String> windowIds = wd.getWindowHandles();

		/*
		 * 
	 //		Approach 1. Convert set to array list

		List<String> windowsList = new ArrayList<String>(windowIds); 
		String parentWindow = windowsList.get(0);
		String childWindow = windowsList.get(1);
		//		Switch to child window
		wd.switchTo().window(childWindow);
		wd.findElement(By.xpath("//div[@class='d-flex web-menu-btn']//li[1]//a[1]")).click();
//		Switch to parent window
		wd.switchTo().window(parentWindow);
		wd.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("admin");
		 */

		//		Approach 2
		for(String winId:windowIds) {
			String title = wd.switchTo().window(winId).getTitle();
			if(title.equals("OrangeHRM HR Software | Free & Open Source HR Sotware | HRMS | HRIS | OrangeHRM")) {
				wd.close();
			}
		}



	}

}

