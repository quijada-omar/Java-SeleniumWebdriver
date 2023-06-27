package day30;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InteractWithElementsUsingJS {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();


        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement firstName = driver.findElement(By.id("name"));

        js.executeScript("arguments[0].setAttribute('value' , 'john')", firstName);

        WebElement radioBtn  = driver.findElement(By.id("male"));

        js.executeScript("arguments[0].click()", radioBtn);
    }
}
