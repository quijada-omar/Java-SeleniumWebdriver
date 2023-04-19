package day25;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleAlerts {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		Alert alertWindow = driver.switchTo().alert();
		System.out.println(alertWindow.getText());
		
		alertWindow.sendKeys("Welcome");
		alertWindow.accept();
		
		String act_text = driver.findElement(By.xpath("//p[@id='result']")).getText();
		String exp_text = "You entered: Welcome"; 
		
		String test_status = act_text.equals(exp_text)?"Test passed":"Test failed";
		System.out.println(test_status);
		
	}
}
