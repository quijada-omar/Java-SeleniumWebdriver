package day22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.netty.channel.unix.DatagramSocketAddress;

public class ConditionMethods {
	public static void main(String[] args) {
		
		WebDriver d = new FirefoxDriver();
		d.get("https://demo.nopcommerce.com/register");
		d.manage().window().maximize();
		
		WebElement logo = d.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		boolean status = logo.isDisplayed();
		System.out.println("Display status of logo: " + status);
		
		WebElement searchbox = d.findElement(By.xpath("//input[@id='small-searchterms']"));
		System.out.println("Display status :" + searchbox.isDisplayed());
		System.out.println("Display status :" + searchbox.isEnabled());
		
		WebElement male_rd = d.findElement(By.xpath("//input[@id='gender-male']"));
		WebElement female_rd = d.findElement(By.xpath("//input[@id='gender-female']"));
		
		System.out.println("Before selection");
		System.out.println(male_rd.isSelected());
		System.out.println(female_rd.isSelected());
		
		
		male_rd.click();
		System.out.println("After male selection");
		System.out.println(male_rd.isSelected());
		System.out.println(female_rd.isSelected());
		
		female_rd.click();
		System.out.println("After female selection");
		System.out.println(male_rd.isSelected());
		System.out.println(female_rd.isSelected());
		
	}
}
