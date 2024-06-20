package codes;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PropertyFileExample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Properties prop = new Properties();
		FileInputStream input = new FileInputStream("D:\\Eclipse-Workspace\\org.selenium\\src\\main\\resources\\config.properties");
		prop.load(input);
		String url = prop.getProperty("url");
		String username = prop.getProperty("user");
		String password = prop.getProperty("pass");
		String fname = prop.getProperty("firstname");
		String lname = prop.getProperty("lastname");
		String driverURL = prop.getProperty("driverPath");
		
		
		String driverPath = System.setProperty("webdriver.chrome.driver","D:\\chromedriver-win64\\chromedriver.exe");
		System.out.println(driverPath);
		// Launch the browser
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(capabilities);
		ChromeDriver driver = new ChromeDriver(options);
		driver.get(url);
		System.out.println(username);
		System.out.println(password);
	}
}
