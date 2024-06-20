package codes;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultsExcel {

    public static void main(String[] args) {
        String driverPath = System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
        System.out.println(driverPath);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(capabilities);

        ChromeDriver driver = new ChromeDriver(options);
        driver.get("http://results.worldcolleges.info/gncresults/nov2023/index.php");

        WebElement input = driver.findElement(By.id("regno"));
        WebElement search = driver.findElement(By.id("gobtn"));

        for (long i = 2113141033001L; i <= 2113141033151L; i++) {
            if (i == 2113141033063L || i == 2113141033064L || i == 2113141033065L || i == 2113141033119L) {
                continue;
            }

            String regno = String.valueOf(i);

            // Clear input field before entering a new registration number
            input.clear();
            input.sendKeys(regno);

            search.click();

            // Use explicit wait for the result table
            WebDriverWait wait = new WebDriverWait(driver, 10);
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='result']/table[2]/tbody/tr[1]")));
            } catch (StaleElementReferenceException e) {
                // Handle stale element exception by re-finding the element
                System.out.println("Stale Element Exception: " + e.getMessage());
                input = driver.findElement(By.id("regno"));
                search = driver.findElement(By.id("gobtn"));
                continue;  // Skip the rest of the loop and retry with the same registration number
            }

            List<WebElement> row = driver.findElements(By.xpath("//*[@id='result']/table[2]/tbody/tr"));
            
            for (int j = 1; j <= row.size() - 1; j++) {
                List<WebElement> col = row.get(j).findElements(By.tagName("td"));
                for (WebElement c : col) {
                    System.out.println(c.getText());
                }
            }
        }

        // Close the WebDriver
        driver.quit();
    }
}
