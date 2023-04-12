package day21;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathAxes {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		String xpath1 = "//a[contains(text(),'NIIT Ltd')]";
		
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
		driver.manage().window().maximize();
		
		
//		Self
		String text = driver.findElement(By.xpath(xpath1 + "/self::a")).getText();
		System.out.println("Self: " + text );
		
//		Parent - Selects the parent of the current node (only one)
		text = driver.findElement(By.xpath(xpath1+"/parent::td")).getText();
		System.out.println(text);
		
//		Child - Selects all children of the current node
		List<WebElement> childs = driver.findElements(By.xpath(xpath1+"/ancestor::tr/child::td"));
		System.out.println("Number of child elements: "+childs.size());
		
//		Ancestor  Selects all ancestors (parent, grandparent, etc)
		text = driver.findElement(By.xpath(xpath1+"/ancestor::tr")).getText();
		System.out.println("Ancestor: "+text);
		
//		Descendant - Select  all the descendants (children, grandchildren, etc.)
		List<WebElement> descendants = driver.findElements(By.xpath(xpath1+"/ancestor::tr/descendant::*"));
		System.out.println("Numbers of descendants: " + descendants.size()); //6
		
//		Following - Selects everything in the document after the closing tag of the current node.
		List<WebElement> followingNodes = driver.findElements(By.xpath(xpath1+"/ancestor::tr/following::tr"));
		System.out.println("Number of the following nodes: "+ followingNodes.size());
		
//		Following-sibling: Selects all siblings after the current node
		List<WebElement> followingSiblings = driver.findElements(By.xpath(xpath1+"/ancestor::tr/following-sibling::tr"));
		System.out.println("Number of the following siblings nodes: "+ followingSiblings.size());
		
//		Preceding - Selects all the nodes that appear before the current node in the document
		List<WebElement> precedings = driver.findElements(By.xpath(xpath1+"/ancestor::tr/preceding::tr"));
		System.out.println("Number of the precedings: "+ precedings.size());
		
//		Preceding sibling - Selects all the siblings before the current node
		List<WebElement> precedingSiblings = driver.findElements(By.xpath(xpath1+"/ancestor::tr/preceding-sibling::tr"));	
		System.out.println("Number of the preceding-siblibgs: "+ precedingSiblings);
		driver.close();
	}
}
