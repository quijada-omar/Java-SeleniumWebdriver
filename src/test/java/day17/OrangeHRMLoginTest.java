package day17;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OrangeHRMLoginTest {
	public static void main(String[] args) {
		/*
		 * 1) Launch browser.
		 * */
		WebDriver firefoxdriver = new FirefoxDriver();
		
		/*
		 * Open URL
		 * */
		
		firefoxdriver.get("https://opensource-demo.orangehrmlive.com");
		firefoxdriver.manage().window().maximize();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 * Provide username
		 * */
		
		WebElement username = firefoxdriver.findElement(By.name("username"));
		WebElement password = firefoxdriver.findElement(By.name("password"));
		
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		
		WebElement loginBtn = firefoxdriver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
		loginBtn.click();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		
		// Label validation after successful login
		WebElement dashboard = null;
		String dashboardActualLabel = null;
		try {
			dashboard = firefoxdriver.findElement(By.xpath("//*[@id='app']/div[1]/div[1]/header/div[1]/div[1]/span/h6"));
			dashboardActualLabel = dashboard.getText();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			dashboardActualLabel = "";
		}
		String dashboardExpectedLabel = "Dashboard";
		
		if(dashboardActualLabel.equals(dashboardExpectedLabel)) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed");
		}
		
			
		

		
	}
}
