package day29;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class DoubleClickDemo {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
        driver.manage().window().maximize();

        driver.switchTo().frame("iframeResult");

        WebElement f1 = driver.findElement(By.xpath("//input[@id='field1']"));
        f1.clear();
        f1.sendKeys("Welcome");

        WebElement copyText = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));

        Actions act = new Actions(driver);
        act.doubleClick(copyText).perform();   // double click action

        WebElement f2 = driver.findElement(By.xpath("//input[@id='field2']"));
        String originalText = f1.getText();
        String copiedText = f2.getText();

        System.out.println(originalText.equals(copiedText));

    }

}
