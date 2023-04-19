package day25;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAuth {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		//https://the-internet.herokuapp.com/basic_auth
		//https://admin:admin@the-internet.herokuapp.com/basic_auth
		
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		driver.manage().window().maximize();
		
		String text = driver.findElement(By.xpath("//p[contains(text(),'Congratulations!')]")).getText();
		
		String login_status = text.contains("Congratulations")?"Successful":"Login failed";
		
		System.out.println(login_status);
	}
}
