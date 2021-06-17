package com.sdet;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SyncConcept {
	
	@Test

	public void SyncConceptTest() throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		Thread.sleep(3000); // static wait
		
//		//implicit wait
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		
//		driver.get("https://www.google.com/");
//		driver.findElement(By.name("q")).sendKeys("Selenium");
//		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
//		
//		driver.findElement(By.xpath("//h3[text()='Selenium WebDriver']")).click();
		
		//Explicit wait
		driver.get("https://www.google.com/");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
//		WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Selenium WebDriver']")));
//		ele.click();
		By eleLoc=By.xpath("//h3[text()='Selenium WebDriver']");
		
//		WebElement eleReturn=genExplicitWait(driver,eleLoc,10);
//		eleReturn.click();
		
		genExplicitWait(driver,eleLoc,10).click();
		
		
		//Fluent wait
		WebDriver driver1=new ChromeDriver();
		driver1.manage().window().maximize();	
		
		Wait<WebDriver> fWait=new FluentWait<WebDriver>(driver1)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
		
		driver1.get("https://www.google.com/");
		
		driver1.findElement(By.name("q")).sendKeys("Selenium");
		driver1.findElement(By.name("q")).sendKeys(Keys.RETURN);
		
		WebElement ele=fWait.until(new Function<WebDriver,WebElement>(){
			public WebElement apply(WebDriver driver2) {
				return driver2.findElement(By.xpath("//h3[text()='Selenium WebDriver']"));
			}
		});
		ele.click();
		

	}
	
	public static WebElement genExplicitWait(WebDriver driver, By locator, int timeout) {
		WebDriverWait waitObj=new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return waitObj.until(ExpectedConditions.visibilityOfElementLocated(locator));
//		return driver.findElement(locator);
		
	}
	

}
