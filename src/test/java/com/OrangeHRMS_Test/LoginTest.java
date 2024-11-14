package com.OrangeHRMS_Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class LoginTest {

	WebDriver driver;
	String URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	
	@BeforeTest
	public void Before() {
	
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
//		driver = new ChromeDriver();
		
		ChromeOptions chromeOptions = new ChromeOptions();
		//WebDriverManager.chromedriver().setup();
		WebDriverManager.chromedriver().driverVersion("130.0.6723.117").setup();
		driver = new ChromeDriver(chromeOptions);
		
		System.out.println("The browser value is Chrome");
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.manage().window().maximize();
		}
	@Test
	public void Login() throws InterruptedException {
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("Admin");
		
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("admin123");
		Thread.sleep(5000);
		//driver.findElement(By.xpath("@type,'submit'")).click();
		
	}
	@AfterTest
	public void quit() {
		driver.quit();
	}
	

}
