package day31;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class CaptureScreenshot {
    public static void main(String[] args) throws IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
/*
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);

        File trg = new File("C:\\Users\\omarq\\Documents\\fullpage.png");
        FileUtils.copyFile(src, trg);
*/

/*
        WebElement featuredProd = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
        File src = featuredProd.getScreenshotAs(OutputType.FILE);
        File trg = new File("C:\\Users\\omarq\\Documents\\specific-product.png");

        FileUtils.copyFile(src,trg);
*/

        WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        File src = logo.getScreenshotAs(OutputType.FILE);
        File trg = new File("C:\\Users\\omarq\\Documents\\specific-webelement.png");
        FileUtils.copyFile(src,trg);


    }
}
