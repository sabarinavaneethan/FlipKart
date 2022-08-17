package org.sample;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {

	WebDriver driver;
	POM p;
	
	@BeforeMethod
	public void BeforeEachMethod() {
		
	WebDriverManager.chromedriver().setup();
	
	driver = new ChromeDriver();
	
	p = new POM(driver);
	
	driver.navigate().to("https://www.flipkart.com/");
	
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	
	
	
	@Test
	@Parameters({"nameofproduct1"})
	public void testCase1(String nameOfProduct) throws InterruptedException {
		
		p.searchProduct(nameOfProduct);
		
		
		p.productHomePage();
		
		p.addingTheProduct();
		
	}
	
	@Test
	@Parameters({"nameofproduct2"})
	public void testCase2(String nameOfProduct) throws InterruptedException {
		
		p.searchProduct(nameOfProduct);
		
		
		p.productHomePage();
		
		p.addingTheProduct();
		
	}
	
	
	
	@AfterMethod
	public void AfterEachMethod() {
		driver.quit();
	}
	
	
}
