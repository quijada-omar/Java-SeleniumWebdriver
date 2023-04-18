package day24;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
		driver.findElement(By.xpath("//div[@class='frmDronpDown']//select[@name='country']")).click();
		List<WebElement> options = driver.findElements(By.xpath("//select[@name='country']/option"));
		
		System.out.println(options.size());
		
		for(WebElement el : options) {
			String text = el.getText();
			if(text.equals("Brazil"))
				el.click();
		}
	}
}
