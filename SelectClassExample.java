package codes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class SelectClassExample {
	public static void main(String[] args) {
		String driverPath = System.setProperty("webdriver.chrome.driver","D:\\chromedriver-win64\\chromedriver.exe");
		System.out.println(driverPath);
		// Launch the browser
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(capabilities);
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
		WebElement select = driver.findElement(By.tagName("select"));
		Select sel = new Select(select);
		sel.selectByVisibleText("India");
		sel.selectByValue("ISR");
		sel.selectByIndex(5);
		driver.close();
	}
}
