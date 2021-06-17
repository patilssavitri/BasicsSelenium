package com.sdet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class frames {
	
	@Test
	public void frameTest() 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		//using frame name
		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.xpath("//a[text()='org.openqa.selenium']")).click();
		driver.switchTo().defaultContent();	
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.xpath("//a/span[text()='Alert']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("classFrame");
		System.out.println(driver.findElement(By.xpath("//h2[@title='Interface Alert']")).getText());
		driver.switchTo().defaultContent();
		System.out.println(driver.getTitle());
	}

}
