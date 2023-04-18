package day24;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDropdownWithSelectTag {
	
	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
				
		WebElement drpCountryEle = driver.findElement(By.xpath("//select[@id='country-list']"));
		Select drpCountry = new Select(drpCountryEle);
//		Selecting an option from the dropdown
//		drpCountry.selectByVisibleText("France");
//		drpCountry.selectByValue("1");
//		drpCountry.selectByIndex(1);
		
		// find total options in dropdown
		List<WebElement> options = drpCountry.getOptions();
		
//		for(int i = 0;i<options.size(); i++)
//		{
//			System.out.println(options.get(i).getText());
//		}
		
//		for(WebElement op:options)
//			System.out.println(op.getText());

		
	}
}
