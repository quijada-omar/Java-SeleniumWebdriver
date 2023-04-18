package day24;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleDropDownWithoutSelect {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");

		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();
		
		List<WebElement> options = driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//label"));
//		
//		for(int i = 0; i<options.size(); i++){
//			System.out.println(options.get(i).getText());
//		}
//		
	
		// Select options from dropdown
//		for(int i = 0; i<options.size(); i++) {
//			if(options.get(i).getText().equals("Java")||options.get(i).getText().equals("Python")) {
//				options.get(i).click();
//			}
//		}
			
		
//		for(WebElement option:options) {
//			String text = option.getText();
//			if(text.equals("Java") || text.equals("Python"))
//				option.click();
//		}
//	
	}
}
