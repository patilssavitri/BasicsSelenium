package com.sdet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IsSelect {
	@Test
	public void isSelectTest()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/register");
		WebElement female=driver.findElement(By.xpath("//input[@id='gender-female']"));
		WebElement male=driver.findElement(By.xpath("//input[@id='gender-male']"));
		System.out.println(female.isSelected());
		System.out.println(male.isSelected());
		male.click();
		System.out.println(female.isSelected());
		System.out.println(male.isSelected());
		female.click();
		System.out.println(female.isSelected());
		System.out.println(male.isSelected());
	}

}
