package codes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitAndFluentWait {

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
		
		driver.manage().window().maximize();
		driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
		
		driver.findElement(By.id("display-other-button")).click();
		WebDriverWait wait = new WebDriverWait(driver,11);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("hidden")));
		driver.findElement(By.id("hidden")).click();
		
		Wait flu = new FluentWait(driver).withTimeout(Duration.ofSeconds(11)).pollingEvery(Duration.ofSeconds(2));
		ExpectedConditions.presenceOfElementLocated(By.id("enable-button"));
		driver.findElement(By.id("enable-button")).click();

	}

}
