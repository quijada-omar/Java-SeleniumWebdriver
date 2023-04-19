package day25;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			WebDriver browser = new ChromeDriver();
			browser.manage().window().maximize();
			
			browser.get("https://mypage.rediff.com/login/dologin");
			
			WebElement signInBtn = browser.findElement(By.xpath("//input[@type='submit']"));
			signInBtn.click();
			
			Alert alert = browser.switchTo().alert();
			alert.accept();
	}

}
