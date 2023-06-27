package day30;

import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;
import java.time.Duration;

public class KeyboardActions {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://text-compare.com/");
        WebElement textArea = driver.findElement(By.xpath("//textarea[@id='inputText1']"));
        textArea.sendKeys("WELCOME TO AUTOMATION");
        Actions act = new Actions(driver);

//      CTRL A
        act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
//      CTRL C
        act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
//      TAB
        act.sendKeys(Keys.TAB).perform();
//      CTRL V
        act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();


        WebElement textArea2 = driver.findElement(By.xpath("//textarea[@id='inputText2']"));
        System.out.println(textArea2.getText());
    }
}
