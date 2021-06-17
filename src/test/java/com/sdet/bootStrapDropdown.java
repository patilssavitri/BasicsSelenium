package com.sdet;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class bootStrapDropdown {
	@Test
	public void bootStrapdropTest()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.hdfcbank.com/");
		
		driver.findElement(By.xpath("//div[@class='drp1']/div[@class='dropdown']")).click();
		List<WebElement> prodType=driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']/li"));
		System.out.println(prodType.size());
		for(WebElement eleOption:prodType)
		{
			if(eleOption.getText().equals("Accounts"))
			{
				eleOption.click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//div[@class='drp2']/div[@class='dropdown']")).click();
		List<WebElement> product=driver.findElements(By.xpath("//ul[@class='dropdown2 dropdown-menu']/li"));
		System.out.println(product.size());
		for(WebElement eleOption:product)
		{
			if(eleOption.getText().equals("Salary Accounts"))
			{
				eleOption.click();
				break;
			}
		}
		driver.findElement(By.xpath("//div[@class='drp1']/div[@class='dropdown']")).click();
		selectBootOption(prodType,"Cards");
		driver.findElement(By.xpath("//div[@class='drp2']/div[@class='dropdown']")).click();
		List<WebElement> product1=driver.findElements(By.xpath("//ul[@class='dropdown2 dropdown-menu']/li"));
		selectBootOption(product1,"Credit Cards");
		driver.quit();
	}
	
	public static void selectBootOption(List<WebElement> lEle, String value)
	{ 
		for(WebElement optionEle: lEle)
		{
			if(optionEle.getText().equals(value))
			{
				optionEle.click();
				break;
			}
		}
	}

}
