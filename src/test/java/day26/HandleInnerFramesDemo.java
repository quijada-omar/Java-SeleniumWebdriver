package day26;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleInnerFramesDemo {
	public static void main(String[] args) {
		WebDriver d = new ChromeDriver();
		d.get("https://ui.vision/demo/webtest/frames/");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement frame1 = d.findElement(By.xpath("//frame[@src='frame_1.html']"));
		d.switchTo().frame(frame1);
		d.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Frame 1");
		d.switchTo().defaultContent();
		
		WebElement frame2 = d.findElement(By.xpath("//frame[@src='frame_2.html']"));
		d.switchTo().frame(frame2);
		d.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Frame 2");
		d.switchTo().defaultContent();
		
		WebElement frame3 = d.findElement(By.xpath("//frame[@src='frame_3.html']"));
		d.switchTo().frame(frame3);
		d.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Frame 3");
		List<WebElement> frameInsideFrame = d.findElements(By.tagName("iframe"));
		System.out.println("Frames inside frame 3: " + frameInsideFrame.size());
		
		d.switchTo().frame(frameInsideFrame.get(0));
		d.findElement(By.xpath("//div[@class='Qr7Oae']//div[contains(.,'Otros:')][@jsname='MaDKvc']//div/div")).click();
		d.findElement(By.xpath("//div/div/input[@type='text']")).sendKeys("My name is Jeff");
		d.findElement(By.xpath("//div/div/span[text()='Web Testing']/preceding::div[@id='i19']")).click();
		
		
		WebElement dropdown = d.findElement(By.xpath("//div[@jsname=\"LgbsSe\"]"));
		dropdown.click();
		
		WebDriverWait w = new WebDriverWait(d, Duration.ofSeconds(15));
		List<WebElement> options = d.findElements(By.xpath("//div[@jsname='V68bde']/div[@role='option']/span"));
		
		
		for (WebElement webElement : options) {
			System.out.println((w.until(ExpectedConditions.elementToBeClickable(webElement)).getText()));
			if(webElement.getText().contains("Well"))
				webElement.click();
		}
		
		
		d.findElement(By.xpath("//span[@class='NPEfkd RveJvd snByac'][text()='Siguiente']")).click();
		
		WebElement box1 = w.until(ExpectedConditions.visibilityOf(d.findElement(By.xpath("//input[@jsname='YPqjbf']")))); 
		WebElement box2 = w.until(ExpectedConditions.visibilityOf(d.findElement(By.xpath("//textarea[@class='KHxj8b tL9Q4c']"))));
		box1.sendKeys("No");
		box2.sendKeys("yes, i will");
	}
	
}