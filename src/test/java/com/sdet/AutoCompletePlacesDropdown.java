package com.sdet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoCompletePlacesDropdown {
	@Test
	public void AutocompPlacesTest() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.twoplugs.com");
		driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
		driver.findElement(By.id("autocomplete")).clear();
		driver.findElement(By.id("autocomplete")).sendKeys("Australia ");
		
		String text;
		do
		{
			driver.findElement(By.id("autocomplete")).sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(3000);
			text=driver.findElement(By.id("autocomplete")).getAttribute("value");
			if(text.equals("Australia Street, Camperdown NSW, Australia"))
			{
				driver.findElement(By.id("autocomplete")).sendKeys(Keys.ENTER);
				Thread.sleep(3000);
				break;
			}		
		}
		while(!text.isEmpty());
		driver.quit();
	}

}
