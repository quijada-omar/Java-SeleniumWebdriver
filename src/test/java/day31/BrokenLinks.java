package day31;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class BrokenLinks {

    public static void main(String[] args) throws IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.deadlinkcity.com/");
        driver.manage().window().maximize();

//       Capture all the links

        List<WebElement> list = driver.findElements(By.tagName("a"));
        System.out.println("Total number of links: " + list.size());

        int brokenLinks = 0;

          for (WebElement linkEl:list){
            String hrefAttr = linkEl.getAttribute("href");
            if(hrefAttr==null || hrefAttr.isEmpty()){
                System.out.println("href empty");
                continue;
            }

              URL linkURL = new URL(hrefAttr);// convert string to url format

              // send request to server
//               open

              HttpURLConnection conn = (HttpURLConnection) linkURL.openConnection();
                conn.connect();

                if (conn.getResponseCode()>=400) {
                    System.out.println(linkEl.getText() + " -> Broken link");
                    brokenLinks++;
                } else {
                    System.out.println(linkEl.getText() + " -> Not broken");
                }
          }

        System.out.println("Total number of broken link " + brokenLinks);

    }

}
