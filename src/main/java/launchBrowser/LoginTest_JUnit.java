package launchBrowser;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest_JUnit {
	static WebDriver driver;

	@BeforeClass
	public static void beforeClass() {
		System.out
				.println(".....This is a BeforeClass.....meaning this execution will happen before all the execution");
	}

	@Before
	public void launchBrowser() {
//PBI: Automate Login Test:	(Positive Test)	
//TestCaseStep 01:(Open Chrome Browser):
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();

//TestCaseStep: 02 (Go to Techfios Website):
		driver.get("https://techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Test
	public void loginTest() {
		try {
//TestCaseStep 03:(Provide Username and Pass Value):
			driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
			driver.findElement(By.id("password")).sendKeys("abc123");

//TestCaseStep 04:(Click on Sign-in Button to Login-in):		
			driver.findElement(By.name("login")).click();

//TestCaseStep 05:(Display Home page);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void invalidLoginTest() throws InterruptedException {
//TestCaseStep 03:(Provide Username and Pass Value):
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc4444123");

//TestCaseStep 04:(Click on Sign-in Button to Login-in):		
		driver.findElement(By.name("login")).click();

//TestCaseStep 05:(Display Home page);

	}

//This test method Intentionally put wrong ID(username1) to fail this TestCase 
	@Test
	public void invalidLoginTest1() {
		driver.findElement(By.id("username1")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
	}

	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		// driver.close();
		driver.quit();
	}

	@AfterClass
	public static void afterClass() {
		System.out.println(".....This is a AfterClass, meaning all the test cases are executed then it happened.....");
	}
}
