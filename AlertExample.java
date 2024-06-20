package codes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AlertExample {

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
		driver.get("https://nxtgenaiacademy.com/alertandpopup/");
		driver.manage().window().maximize();
		
		//alert
		driver.findElement(By.xpath("//button[@name='alertbox']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		//confirmation alert
		driver.findElement(By.xpath("//button[@name='confirmalertbox']")).click();
		driver.switchTo().alert();
		alert.dismiss();
		
		//prompt alert
		driver.findElement(By.xpath("//button[@name='promptalertbox1234']")).click();
		driver.switchTo().alert();
		alert.sendKeys("Yes");
		alert.accept();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.close();
		
		
	}

}
