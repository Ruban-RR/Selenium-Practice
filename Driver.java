package codes;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Driver {
	
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
	driver.get("http://results.worldcolleges.info/gncresults/nov2023/index.php");

//Load the url
	/*
	 driver.get("https://www.saucedemo.com/");
     driver.manage().window().maximize();
     driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
     driver.findElement(By.id("password")).sendKeys("secret_sauce");
     driver.findElement(By.id("login-button")).click();
     driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
     driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
     driver.findElement(By.xpath("//button[@id='checkout']")).click();
     driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("ruban");
     driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("Rajasekar");
     driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("600057");
     driver.findElement(By.xpath("//input[@id='continue']")).click();
     float pricetotal=Float.parseFloat(driver.findElement(By.xpath("//div[@class='summary_subtotal_label']")).getText().substring(13));
     float tax = Float.parseFloat(driver.findElement(By.xpath("//div[@class='summary_tax_label']")).getText().substring(6));	
     float total = Float.parseFloat(driver.findElement(By.xpath("//div[@class='summary_info_label summary_total_label']")).getText().substring(8));
     if(pricetotal+tax==total) {
     		System.out.println("correct");
     	}
     	else {
     		System.out.println("wrong");
     	}
     */
     
     
     
	
	
}
}
	
