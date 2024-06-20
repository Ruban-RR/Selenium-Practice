package codes;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;
public class StaticWebTable {

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
		
	      driver.get("https://qavbox.github.io/demo/webtable");
		     // Wait for the table to load
		      //  WebDriverWait wait = new WebDriverWait(driver, 10);
		      //  WebElement table = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("product")));

		        // Get all rows from the table
		        List<WebElement> rows = driver.findElements(By.tagName("tr"));
		        System.out.println(rows);

		        // Initialize a two-dimensional array to store extracted data
		        String[][] data = new String[rows.size()-1][];

		        // Iterate through rows and extract data from columns
		        for (int i = 1; i < rows.size(); i++) { // Skip the header row
		            List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
		            //data[i - 1] = new String[columns.size()];
		            // (int j = 0; j < columns.size(); j++) {
		               // data[i - 1][j] = columns.get(j).getText();
		            for(WebElement col:columns) {
		            	System.out.println(col.getText());	
		            }
     
		        }
	}}
