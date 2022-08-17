package org.sample;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitExample {

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

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		
		WebElement internalStorage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Internal Storage']")));
		internalStorage.click();
		
		
		WebElement specifiedStorage = driver.findElement(By.xpath("//div[text()='128 - 255.9 GB']"));
		specifiedStorage.click();
		
		
		
	}

}
