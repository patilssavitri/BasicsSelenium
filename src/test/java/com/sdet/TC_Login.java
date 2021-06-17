package com.sdet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class TC_Login {
	@Test
	public void login_Test()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("abc");
		driver.findElement(By.id("txtPassword")).sendKeys("test");
		driver.findElement(By.id("btnLogin")).click();
		
		Assert.assertNotEquals(driver.getTitle(), "test");
		
		driver.close();
	}
	
	@Test
	public void excel_Test()
	{
		
	}

}
