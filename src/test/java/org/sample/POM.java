package org.sample;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class POM {

	
	WebDriver driver;
	
	By searchBox = By.xpath("//input[@type=\"text\"]");
	
	By searchButton = By.xpath("//button[@class=\"L0Z3Pu\"]");
	
	By loginCancelButton = By.xpath("//button[contains(text(),'✕')]");
	
	By internalStorage = By.xpath("//div[text()=\"Internal Storage\"]");
	
	By gB =By.xpath("//div[text()='128 - 255.9 GB']");
	
	By productName = By.xpath("//div[text()='APPLE iPhone 11 (Black, 128 GB)']");
	
	By addCart= By.xpath("//button[@class=\"_2KpZ6l _2U9uOA _3v1-ww\"]");
	
	By placeOrder = By.xpath("//button[@class=\"_2KpZ6l _2ObVJD _3AWRsL\"]");
	
	
	
	public  POM(WebDriver driver) 
	{
		this.driver= driver;	
	}
	
	
	public void searchProduct(String productName) throws InterruptedException 
	{
		driver.findElement(loginCancelButton).click();
		driver.findElement(searchBox).sendKeys(productName);
		
		driver.findElement(searchButton).click();
		
	}
	
	public void productHomePage() throws InterruptedException {
		
		
		
		driver.findElement(internalStorage).click();
		
		driver.findElement(gB).click();
		Thread.sleep(2000);
		
	}
	
	public void addingTheProduct() throws InterruptedException {
		
		
		
		driver.findElement(productName).click();
		
		String par = driver.getWindowHandle();
		
		Set<String> All = driver.getWindowHandles();
		
		for (String string : All) 
		{
			
			if (!string.equals(par)) 
			{
				driver.switchTo().window(string);
			}
		}
		
		driver.findElement(addCart).click();
		
		
		driver.findElement(placeOrder).click();
		
	}
	
	
	
	
	
}
