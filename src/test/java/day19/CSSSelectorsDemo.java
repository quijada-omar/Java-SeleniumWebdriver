package day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CSSSelectorsDemo {
	public static void main(String[] args) {

		WebDriver browser = new FirefoxDriver();

		browser.get("https://demo.nopcommerce.com/");
		browser.manage().window().maximize();

		//		search box 
		//		tag & id
		/*
		 * Tag id #
		 * 
		 * Ex: input#small-searchterms
		 * 		#small-searchterms
		 * 
		 * Tag class .
		 * Ex: input.search-box-text
		 * 		.search-box-text
		 * 
		 * Tag attribute []
		 * Ex: input[name='q']
		 * 		[name='q']
		 * 
		 * Tag class attribute
		 * Ex: input.search-box-text[name='q']
		 * 		.search-box-text[name='q']
		 *  
		 * */
		//		id
		//		browser.findElement(By.cssSelector("input#small-searchterms")).sendKeys("MacBook");
		//		browser.findElement(By.cssSelector("#small-searchterms")).sendKeys("MacBook");

		//		tag class
		//		browser.findElement(By.cssSelector("input.search-box-text")).sendKeys("MacBook");
		//		browser.findElement(By.cssSelector(".search-box-text")).sendKeys("MacBook");


		//		tag & attribute
		//		browser.findElement(By.cssSelector("input[name='q']")).sendKeys("Macbook");
		//		browser.findElement(By.cssSelector("[name='q']")).sendKeys("Macbook");

		// 		tag class attribute
				browser.findElement(By.cssSelector("input.search-box-text[name='q']")).sendKeys("Macbook");
				


	}
}
