package codes;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class WebTableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driverPath = System.setProperty("webdriver.chrome.driver","D:\\chromedriver-win64\\chromedriver.exe");
		System.out.println(driverPath);
		// Launch the browser
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(capabilities);
		ChromeDriver driver = new ChromeDriver(options);
		//  DYNAMIC WEB TABLE 
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		WebElement table = driver.findElement(By.id("countries"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for(WebElement row:rows) {
			List<WebElement> cols = row.findElements(By.tagName("td"));
			for(WebElement col:cols) {
				System.out.print(col.getText());
			}
			System.out.println();
		}
		
		/* To get specific value
		driver.get("https://demo.seleniumeasy.com/table-sort-search-demo.html");

        // Sort the table by "Date" column
        WebElement nameHeader = driver.findElement(By.xpath("//thead[@class='thead-inverse']/tr/th[@class='sorting'][4]"));
        nameHeader.click();
        
        
       
        
        WebElement tablevalue =driver.findElement(By.xpath("//tbody/tr[@role='row'][5]/td[4]"));
        System.out.println(tablevalue.getText());
      
		*/


		
		
		
	}
}
