package codes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IFrame {

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
		
		driver.get("https://demo.automationtesting.in/Frames.html");
		driver.findElement(By.xpath("//a[@href='#Multiple']")).click();
		//Nested iframe
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@style='float: left;height: 300px;width:600px']"));
		driver.switchTo().frame(frame1);
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@style='float: left;height: 250px;width: 400px']"));
		driver.switchTo().frame(frame2);
		
		//Single iframe
		//WebElement frame = driver.findElement(By.id("singleframe"));
		//driver.switchTo().frame(frame);
		driver.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("ruban");
	}
	
}
