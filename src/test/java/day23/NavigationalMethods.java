package day23;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationalMethods {
	public static void main(String[] args) {
		WebDriver web = new ChromeDriver();
		
		web.get("https://www.amazon.com.mx");
		web.get("https://www.facebook.com");
		
		web.navigate().back();
		web.navigate().forward();
	}
}
