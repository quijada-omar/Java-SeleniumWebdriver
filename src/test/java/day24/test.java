package day24;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {
	public static void main(String[] args) {

		WebDriver d = new ChromeDriver();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.manage().window().maximize();
		d.get("https://store.steampowered.com/search/?term=dota+2");
			
		WebElement table = d.findElement(By.xpath("//div[@id='LanguageFilter_Container']"));
		List<WebElement> rows = table.findElements(By.xpath("//div[@data-param='supportedlang']"));
		
		for(WebElement row : rows) {
			if(!row.isSelected())
				row.click();
		}
		
		
		
	}
}
