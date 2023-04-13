package day23;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class FluentWaitDemo {
	public static void main(String[] args) {

		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();
/*
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30L))
				.pollingEvery(Duration.ofSeconds(5L))
				.ignoring(NoSuchElementException.class);
*/
		
		FluentWait wait = new FluentWait(driver);
		wait.withTimeout(Duration.ofSeconds(50));
		wait.pollingEvery(Duration.ofSeconds(15));
		wait.ignoring(NoSuchElementException.class);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	
/*
		WebElement username = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) 
			{
				return driver.findElement(By.id("//input[@placeholder='Username']"));
			}
		}
				);
*/

		WebElement username = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
		username.sendKeys("Admin");
		
		
	}
}
