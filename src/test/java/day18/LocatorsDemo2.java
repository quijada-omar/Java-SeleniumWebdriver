package day18;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocatorsDemo2 {
	public static void main(String[] args) {

		WebDriver browser = new FirefoxDriver();

		//		Open application	
		browser.get("http://automationpractice.pl/index.php");
		//		Get URL
		browser.manage().window().maximize();
		//		Capture all the sliders on the home page.
		List<WebElement> sliders = browser.findElements(By.className("homeslider-container"));
		System.out.println("Number of sliders: "+sliders.size());
		//		Find images in home page.
		List<WebElement> imgs = browser.findElements(By.tagName("img"));
		System.out.println("Number of images: "+imgs.size());
		//		How to capture total number of links
		List<WebElement> links = browser.findElements(By.tagName("a"));
		System.out.println("Total number of links: " + links.size());
		
		/*
		 * 
		 * findElement(locator) --> WebElement
		 * findElements(locator) --> List<WebElement>
		 * 
		 * Scenario 1
		 * 
		 * We pass locator in both places
		 * 
		 * locator is matching with single web element
		 * 
		 * findElement(loc) ---> Single WebElement - returns WebElement
		 * findElements(loc) --->  List w/ Single WebElement - returns List<WebElement>
		 *  
		 */

		/*
		 * Scenario 2: Locator is matching with multiple webElements
		 * 
		 * findElement(loc)  - single web element(first) - WebElement
		 * findElements(loc) - multiple web elements - List<WebElement>
		 * 
		 * 
		 * */
		
		/*
		 * Scenario 3:
		 * Locator is incorrect
		 * 
		 * findElement(loc)  -  NoSuchElementException.
		 * findElements(loc) -  returns zero
		 * 
		 * 
		 * */


		//		Close
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		browser.quit();
	}
}