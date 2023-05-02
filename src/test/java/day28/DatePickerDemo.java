package day28;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		
//		Switch to frame
		
//		Approach 1
//		driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("15/10/2022");
	
//		Approach 2
//		dob past date
//		travel future date
		String year = "2020";
		String month = "June";
		String day = "8";
		
		driver.findElement(By.xpath("//input[@id='datepicker']")).click(); // open date picker
	//	Select Month & year
		while(true)
		{
			String monthUI = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String yearUI = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			if(monthUI.equals(month) && yearUI.equals(year))
			{
				break;
			}
			
//			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			
		}
	
		// Select date
		List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		
		for(WebElement td : allDates) {
			if(td.getText().equals(day)) {
				td.click();
				break;
			}
		}
		
		
	
	}
}
