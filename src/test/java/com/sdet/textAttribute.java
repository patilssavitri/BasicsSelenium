package com.sdet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class textAttribute {
	
	@Test
	public void getTxtAttributeDiffTest()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://admin-demo.nopcommerce.com/login");
		
		WebElement EmailWebElement=driver.findElement(By.xpath("//input[@id='Email']"));
		System.out.println(EmailWebElement.getAttribute("value"));
		System.out.println(EmailWebElement.getText());
		EmailWebElement.clear();
		EmailWebElement.sendKeys("test@gmail.com");
		
		System.out.println(EmailWebElement.getText());
		System.out.println(EmailWebElement.getAttribute("value"));
		System.out.println(EmailWebElement.getAttribute("data-val-required"));
		
		//Login
		WebElement Login=driver.findElement(By.xpath("//button[@type='submit']"));
		System.out.println(Login.getText());
		System.out.println(Login.getAttribute("type"));
		System.out.println(Login.getAttribute("class"));
		
		//heading
		WebElement heading=driver.findElement(By.xpath("//div[@class='page-title']/h1"));
		System.out.println(heading.getText());
	}

}
