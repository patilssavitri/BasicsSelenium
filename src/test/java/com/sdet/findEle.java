package com.sdet;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class findEle {
	@Test
	
	public void findEleTest()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		WebElement search =driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		search.sendKeys("test");
		
		WebElement ele=driver.findElement(By.xpath("//div[@class='footer-upper']//a"));
		System.out.println(ele.getText());
		
//		WebElement btn = driver.findElement(By.xpath("//button[@type='submi']"));
//		btn.click();
		
		List<WebElement> liEle=driver.findElements(By.xpath("//div[@class='footer-upper']//a"));
		System.out.println(liEle.size());
		for(WebElement e:liEle) {
			System.out.println(e.getText());
		}
		
		List<WebElement> liEle1=driver.findElements(By.xpath("//div[@class='footer-upper']//t"));
		System.out.println(liEle1.size());
		for(WebElement e1:liEle1) {
			System.out.println(e1.getText());
		}
		
		List<WebElement> liLogo=driver.findElements(By.xpath("//img[@alt='nopCommerce demo store']"));
		System.out.println(liLogo.size());
		
		
	}

}
