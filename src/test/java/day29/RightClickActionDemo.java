package day29;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickActionDemo {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

        WebElement rightClickMe  = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));

        Actions actions = new Actions(driver);

        actions.contextClick(rightClickMe).build().perform();

        driver.findElement(By.xpath("//span[normalize-space()='Copy']")).click();

        Thread.sleep(5000);

        driver.switchTo().alert().accept();
    }
}
