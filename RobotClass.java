package codes;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RobotClass {

	public static void main(String[] args) throws AWTException {
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
		
		driver.get("https://gnc-egovernance.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='uname']")).sendKeys("2113141033132");
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("RUBANMR51");
		driver.findElement(By.id("loginbutton")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@id='ext-gen20']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[@id='ext-gen112']")).click();
		//WebDriverWait wait = new WebDriverWait(driver,11);
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@id='firstgen_upload']")));
		Wait flu = new FluentWait(driver).withTimeout(Duration.ofSeconds(11)).pollingEvery(Duration.ofSeconds(2));
		ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='firstgen_upload']"));
		driver.findElement(By.xpath("//input[@id='firstgen_upload']")).click();
		driver.quit();
		
		
	
	}

}
