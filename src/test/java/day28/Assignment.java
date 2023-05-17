package day28;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment {

	static void selectDate(WebDriver driver, WebElement datePicker, String date, String month, String year) {
		datePicker.click();
		
		Select drop = new Select(driver.findElement(By.xpath("//select[@aria-label='Select month']")));
		drop.selectByVisibleText(month);
		
		drop = new Select(driver.findElement(By.xpath("//select[@aria-label='Select year']")));
		drop.selectByVisibleText(year);
		
		List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr/td"));
		
		for (WebElement dt : dates) {
			if(dt.getText().equals(date)) {
				dt.click();
				break;
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();
		
		WebElement product =  driver.findElement(By.id("product_550"));
		product.click();
		
		WebElement firstGivenName = driver.findElement(By.id("travname"));
		firstGivenName.sendKeys("John");
		
		WebElement lastSurName = driver.findElement(By.id("travlastname"));
		lastSurName.sendKeys("Kennedy");
		
		WebElement orderComments = driver.findElement(By.id("order_comments"));
		orderComments.sendKeys("Testing");
		
		WebElement dobDatePicker = driver.findElement(By.xpath("//input[@id='dob']"));
		selectDate(driver, dobDatePicker, "5", "Jul", "1985");
		
		WebElement sex = driver.findElement(By.id("sex_2"));
		sex.click();
		
		WebElement roundTrip = driver.findElement(By.id("traveltype_2"));
		roundTrip.click();
		
		WebElement fromCity = driver.findElement(By.id("fromcity"));
		fromCity.sendKeys("Hyderabad");
		
		WebElement toCity = driver.findElement(By.id("tocity"));
		toCity.sendKeys("Delhi");
		
		
		
		
		
	}
	
}
