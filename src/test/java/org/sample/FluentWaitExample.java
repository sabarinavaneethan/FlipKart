package org.sample;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitExample {

	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https://www.flipkart.com/");

		driver.manage().window().maximize();

		WebElement loginCancelButton = driver.findElement(By.xpath("//button[contains(text(),'✕')]"));
		loginCancelButton.click();

		WebElement searchBox = driver.findElement(By.xpath("//input[@type=\"text\"]"));
		searchBox.sendKeys("Iphone");

		WebElement searchButton = driver.findElement(By.xpath("//button[@class=\"L0Z3Pu\"]"));
		searchButton.click();
		
		
		
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
		
		
		WebElement internalStorage = wait.until(new Function<WebDriver, WebElement>()
		{

			public WebElement apply(WebDriver driver) {
				
				return driver.findElement(By.xpath("//div[text()='Internal Storage']"));
			}

			
		});
		
		internalStorage.click();
		

		
		WebElement specifiedStorage = driver.findElement(By.xpath("//div[text()='128 - 255.9 GB']"));
		specifiedStorage.click();
			
		driver.quit();
	}

}

