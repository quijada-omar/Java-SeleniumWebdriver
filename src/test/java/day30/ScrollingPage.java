package day30;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingPage {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
        driver.manage().window().maximize();

        JavascriptExecutor js = driver;
//      Scroll pixels
        js.executeScript("window.scrollBy(0,3000)", "");
        System.out.println(js.executeScript("return window.pageYOffset;"));
//      Scroll until element is present
        WebElement flag = driver.findElement(By.xpath("//img[@alt='Flag of India']"));
        js.executeScript("arguments[0].scrollIntoView();", flag);




    }
}
