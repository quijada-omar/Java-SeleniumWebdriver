package day28;

import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BlazersDemo {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();

		WebElement departureCity = driver.findElement(By.xpath("//select[@name='fromPort']"));
		departureCity.click();

		List<WebElement> depCityOptions = driver.findElements(By.xpath("//select[@name='fromPort']//option"));

		for (WebElement option : depCityOptions) {
			if(option.getText().equals("Mexico City"))
			{
				//				System.out.println("I found Mexico city");
				option.click();	
			}
		}

		WebElement destinationCity = driver.findElement(By.xpath("//select[@name='toPort']"));
		destinationCity.click();
		List<WebElement> destCityOptions = driver.findElements(By.xpath("//select[@name='toPort']//option"));

		for (WebElement option : destCityOptions) {
			if(option.getText().equals("New York"))
			{
				//				System.out.println("I found New York");
				option.click();	
			}
		}

		WebElement submitBtn = driver.findElement(By.xpath("//div//input[@type='submit']"));
		submitBtn.click();

		WebElement table = driver.findElement(By.className("table"));

		int rowsSize=driver.findElements(By.xpath("//table[@class='table']//tbody//tr")).size();
		System.out.println("number of rows in table:"+rowsSize); //5
		float[] prices = new float[rowsSize];
		for(int i = 1; i <= rowsSize; i++) {
			String priceCell = driver.findElement(By.xpath("//tbody//tr["+i+"]//td[6]")).getText();
			prices[i-1]= Float.parseFloat(priceCell.replace("$", ""));
			System.out.println(prices[i-1]);
		}

		Arrays.sort(prices);
		System.out.println(Arrays.toString(prices));
		String lowestPrice = "$"+prices[0];
		System.out.println("Lowest price: "+ lowestPrice);

		for(int r=1;r<=rowsSize;r++)
		{
			String price=driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+r+"]/td[6]")).getText();
			if(price.equals(lowestPrice))
			{
				System.out.println(true);
				driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+r+"]/td[1]//input")).click();
				break;
			}
		}

		driver.findElement(By.id("inputName")).sendKeys("Johan");
		driver.findElement(By.id("address")).sendKeys("1403 British Beauty Ln");
		driver.findElement(By.id("city")).sendKeys("Columbus Bus");
		driver.findElement(By.id("state")).sendKeys("OHIO");
		driver.findElement(By.id("zipCode")).sendKeys("43240");
		driver.findElement(By.id("creditCardNumber")).sendKeys("6789067345231267");
		driver.findElement(By.id("creditCardYear")).clear();
		driver.findElement(By.id("creditCardYear")).sendKeys("2022");
		driver.findElement(By.id("nameOnCard")).sendKeys("John Kneedy");
		driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();

		String msg=driver.findElement(By.xpath("//h1")).getText();

		if(msg.contains("Thank you for your purchase"))
		{
			System.out.println("Success !! Passed");
		}
		else
		{
			System.out.println("Failed");	
		}

		driver.quit();
	}
}
