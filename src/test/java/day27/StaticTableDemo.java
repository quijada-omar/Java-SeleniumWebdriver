package day27;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticTableDemo {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");

		driver.manage().window().maximize();

		// Find total # rows
		// Approach #1
		System.out.println("Approach 1");
		List<WebElement> rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
		int noRows = rows.size();
		System.out.println("Size: " + noRows);   // 7 PREFERRED

		// Approach #2 
		//		System.out.println("Approach 2");
		//		List<WebElement> rows2 = driver.findElements(By.tagName("tr"));
		//		int noRows2 = rows2.size();
		//		System.out.println("Size: " + noRows2);  // 8 Prefered if only there's one table

		// Find total # columns
		List<WebElement> cols = driver.findElements(By.xpath("//table[@name='BookTable']//th"));
		int noCols = cols.size();
		//		int cols1 = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		//		int cols2 = driver.findElements(By.tagName("th")).size();   // dont prefer, just in case one single table.
		//		System.out.println("Cols1: " + cols1 + ", Cols2: " + cols2);

		// Read specific row & column data
//		String masterInSelenium = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();
//		System.out.println(masterInSelenium);
		
		// Readdata from all the rows & columns
		
//		for(int r = 2; r <= noRows; r++)
//		{
//			for(int c = 1; c <= noCols; c++ )
//			{
//				String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
//				System.out.print(value+"\t\t");  
//			}
//			System.out.println();
//		}

		// Print book whose author is Amit
//		for(int r = 2; r <= noRows; r++) {
//			String author = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
//			if(author.equals("Mukesh")) {
//				String bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[1]")).getText();
//				System.out.println("Author: " + author + ", book: "+ bookName);
//			}
//		}
//		
			int price = 0;
		for(int r=2; r <= noRows ;r++)
		{
			String priceString = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[4]")).getText();
			price = price + Integer.parseInt(priceString);
		}
			System.out.println("Total cost of books "+price);
		
		driver.quit();


		// find sum of prices for all books.




	}
}
