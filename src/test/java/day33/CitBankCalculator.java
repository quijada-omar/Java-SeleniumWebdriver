package day33;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CitBankCalculator {
// CitBankData
	public static String URL  = "https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator";
	public static String file = System.getProperty("user.dir")+"\\testdata\\CitBankData.xlsx";
	public static String xlsheet = "Hoja 1";	
	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		
		int rows = ExcelUtils.getRowCount(file, xlsheet);
		int columns = ExcelUtils.getCellCount(file, xlsheet, rows);
		
		System.out.println("Rows: " + rows);
		System.out.println("Columns: " + columns);
		
		WebElement calbutton = driver.findElement(By.xpath("//button[@id='CIT-chart-submit']")); 
		for(int i = 1; i <= rows; i++) {
			String depositAmount = ExcelUtils.getCellData(file, xlsheet, i, 0);			
			String interestRate = ExcelUtils.getCellData(file, xlsheet, i, 1);
			String lengthInMonths = ExcelUtils.getCellData(file, xlsheet, i, 2);
			String compounding = ExcelUtils.getCellData(file, xlsheet, i, 3);
			String exptotal = ExcelUtils.getCellData(file, xlsheet, i, 4);			
			System.out.println(String.format("Deposit Amount: %s | Interest rate: %s | Length: %s | Compounding: %s | Total: %s | ", depositAmount, interestRate, lengthInMonths, compounding, exptotal));
			
			WebElement depositAmountEle = driver.findElement(By.id("mat-input-0"));
			WebElement lengthMonthsEle = driver.findElement(By.id("mat-input-1"));
			WebElement interestRateEle = driver.findElement(By.id("mat-input-2"));
			WebElement compoundingEle = driver.findElement(By.xpath("//mat-select[@id='mat-select-0']"));
			
			depositAmountEle.clear();
			lengthMonthsEle.clear();
			interestRateEle.clear();
			
			depositAmountEle.sendKeys(depositAmount);
			lengthMonthsEle.sendKeys(lengthInMonths);
			interestRateEle.sendKeys(interestRate);
			
			compoundingEle.click();
			Thread.sleep(3000);
			List<WebElement> options = driver.findElements(By.xpath("//div[@id='mat-select-0-panel']//mat-option"));
			for(WebElement option: options) {
				if(option.getText().equals(compounding)) {
					option.click();
				}
			}
			
			calbutton.click();   ///click on button to calculate cd calculation based on xl cell data
			String acttotal = driver.findElement(By.xpath("//span[@id='displayTotalValue']")).getText();
			
			System.out.println("act total is: " + acttotal);
			System.out.println("exp total is: " + exptotal);
			
			if(exptotal.equals(acttotal)) {
				ExcelUtils.setCellData(file, xlsheet, i, 6, "Passed " + LocalDateTime.now());
			} else {
				ExcelUtils.setCellData(file, xlsheet, i, 6, "Failed " + LocalDateTime.now());
			}
		}	
		
	}
	
}
