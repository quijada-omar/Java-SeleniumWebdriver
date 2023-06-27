package day29;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LocationOfElements {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement logo = driver.findElement(By.xpath("//img[@alt='company-branding']"));

//        System.out.println(logo.getLocation());
//
//        driver.manage().window().maximize();
//
//        System.out.println(logo.getLocation());
//
//        driver.manage().window().fullscreen();
//
//        System.out.println(logo.getLocation());

        Point p = new Point(100,100);

        driver.manage().window().setPosition(p);



    }

}
