package codes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

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
		try {
		driver.get("https://demo.automationtesting.in/Static.html");
		WebElement source = driver.findElement(By.xpath("//img[@id='angular']"));
		WebElement target = driver.findElement(By.xpath("//div[@id='droparea']"));
		Actions act = new Actions(driver);
		act.dragAndDrop(source, target).build().perform();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
