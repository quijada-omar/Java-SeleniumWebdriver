package day24;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCheckboxes {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		driver.manage().window().maximize();
		
//		Single checkbox
//		driver.findElement(By.xpath("//input[@id='monday']")).click();
//		Multiple checkboxes
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		System.out.println("Total number of checkbox: " + checkboxes.size());
		
//		for(int i = 0; i < checkboxes.size(); i++) {
//			checkboxes.get(i).click();
//		}
		
		
//		for(WebElement chkbox: checkboxes)
//			chkbox.click();

//		for(int i=(checkboxes.size()-2); i<checkboxes.size();i++) {
//			checkboxes.get(i).click();			
//		}
		
//		for(int i = 0; i<2; i++) {
//			checkboxes.get(i).click();
//		}
		
		for(int i = 0;i<checkboxes.size();i++)
			checkboxes.get(i).click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i = 0;i<checkboxes.size();i++)
			if(checkboxes.get(i).isSelected())
				checkboxes.get(i).click();
	
		
	}
}
