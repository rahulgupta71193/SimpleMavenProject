package testcase;

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestCaseone {
	
	public WebDriver driver;

	@BeforeSuite
	public void setUp()
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\SimpleMavenProject\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Test(priority=1)
	public void navigateURL() throws InterruptedException
	{
		driver.get("https://www.google.com");
		Thread.sleep(5000);
		
		driver.findElement(By.name("q")).sendKeys("hello");
		Thread.sleep(5000);
	}
	@Test(priority=2)
	public void validateTitle()
	{
		System.out.println(driver.getTitle());
		Assert.assertEquals("Google",driver.getTitle());
	}
	

	@AfterSuite
	public void tearDown()
	{
		driver.quit();
	}

}
