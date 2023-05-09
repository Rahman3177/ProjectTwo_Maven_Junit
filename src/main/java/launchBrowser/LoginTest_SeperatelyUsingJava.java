package launchBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest_SeperatelyUsingJava {
	// Here we need to declare global variable (WebDriver driver = new
	// ChromeDriver();)
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// Positive Testing
		launchBrowser();
		loginTest();
		tearDown();

		// Negative Testing
		launchBrowser();
		invalidLoginTest();
		tearDown();
	}

	public static void launchBrowser() {
		// PBI: Automate Login Test: (Positive Test)
		// TestCaseStep 01:(Open Chrome Browser):
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();

		// TestCaseStep: 02 (Go to Techfios Website):
		driver.get("https://techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	public static void loginTest() {
		// TestCaseStep 03:(Provide Username and Pass Value):
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");

		// TestCaseStep 04:(Click on Sign-in Button to Login-in):
		driver.findElement(By.name("login")).click();

		// TestCaseStep 05:(Display Home page);

	}

	public static void invalidLoginTest() {
		// TestCaseStep 03:(Provide Username and Pass Value):
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc4444123");

		// TestCaseStep 04:(Click on Sign-in Button to Login-in):
		driver.findElement(By.name("login")).click();

		// TestCaseStep 05:(Display Home page);

	}

	public static void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}
