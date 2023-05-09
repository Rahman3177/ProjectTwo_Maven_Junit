package launchBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	public static void main(String[] args) throws InterruptedException {
		// As per Sample Test we need to open the Chrome Browser

		// driver path location....all 3 are okay
//				System.setProperty("webdriver.chrome.driver", "D:\\TechFios_Feb 13_2021\\SeleniumWorkspace_April2023\\ProjectTwo_Maven\\driver\\chromedriver.exe");
//				System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe"); //This imply only for this project

		// PBI: Automate Login Test: (Positive Test)
		// TestCaseStep 01:(Open Chrome Browser):
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// TestCaseStep: 02 (Go to Techfios Website):
		driver.get("https://techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		// TestCaseStep 03:(Provide Username and Pass Value):
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");

		// TestCaseStep 04:(Click on Sign-in Button to Login-in):
		driver.findElement(By.name("login")).click();

		// TestCaseStep 05:(Display Home page);

		Thread.sleep(4000);
		driver.close();
	}

}
