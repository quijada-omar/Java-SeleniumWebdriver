package day23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SleepStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		
		/* Pros
		 * Easy to use.
		 * 
		 * Cons
		 * If the time is not sufficient then you'll get an exception
		 * If will wait for maximum timeout. This will reduce the performance script
		 * Multiple times
		 * Not a selenium command
		 * 
		 * 
		 * */
	}
}
