package day29;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderDemo {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        WebElement min_slider = driver.findElement(By.xpath("//span[1]"));
        System.out.println("Location of minimum slider" + min_slider.getLocation());
        actions.dragAndDropBy(min_slider, 100, 250).perform();
        System.out.println("Location of slider after moving" + min_slider.getLocation());


        WebElement max_slider = driver.findElement(By.xpath("//span[2]"));
        System.out.println("Current location of max slider " + max_slider.getLocation());
        actions.dragAndDropBy(max_slider, -100, 250).perform();


    }
}
