package com.sdet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class parentFramet {
	@Test
	public void parentframeTest() 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
		
		driver.switchTo().frame("iframeResult"); 
		driver.switchTo().frame(0); //using index
		System.out.println(driver.findElement(By.xpath("//h1")).getText());
		driver.switchTo().parentFrame();
		System.out.println(driver.findElement(By.xpath("//h2")).getText());
		System.out.println(driver.findElement(By.xpath("//p[contains(text(),'iframe')]")).getText());
		
	}
}
