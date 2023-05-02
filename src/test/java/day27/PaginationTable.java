package day27;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PaginationTable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://demo.opencart.com/admin/index.php");
			driver.manage().window().maximize();
			
			WebElement username = driver.findElement(By.id("input-username"));
			username.clear();
			username.sendKeys("demo");
			
			WebElement password = driver.findElement(By.id("input-password"));
			password.clear();
			password.sendKeys("demo");
			
			driver.findElement(By.xpath("//button[text()=' Login']")).click();
			
			if(driver.findElement(By.xpath("//button[@class='btn-close']")).isDisplayed()) {
				driver.findElement(By.xpath("//button[@class='btn-close']")).click();
			}
			
			driver.findElement(By.xpath("//a[@class='parent collapsed'][normalize-space()='Customers']")).click();
			driver.findElement(By.xpath("//ul[@class='collapse show']//a[contains(text(),'Customers')]")).click();
			
			String text = driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
			
			int totalPages = Integer.parseInt(text.substring(text.indexOf("(")+1, text.indexOf("Pages")-1));
			System.out.println("Total pages: " + totalPages);
			
			for(int p=1; p<=5; p++) {
				if(totalPages>1) {
					WebElement activePage = driver.findElement(By.xpath("//ul[@class='pagination']//li//*[text()="+p+"]"));
					System.out.println("Active page: " + activePage.getText());
					activePage.click();
					Thread.sleep(2000);
				}
				
				int rowsNo = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
				System.out.println("Total number of rows in active page : "+ rowsNo);
				
				for(int r=1; r<=rowsNo; r++) {
					String customerName = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[2]")).getText();
					String customerEmail = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[3]")).getText();
					String status = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[5]")).getText();
					
					System.out.println(customerName+"\t"+customerEmail+"\t"+status);
				}
			}
	}

}
