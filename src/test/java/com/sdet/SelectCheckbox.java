package com.sdet;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectCheckbox {

	@Test
	public void SelectChkBocTest()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
//		//Select specific checkbox
//		driver.findElement(By.id("monday")).click();
//
//		//Select all checkboxes
//
//		List<WebElement> liChk=driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
//		System.out.println(liChk.size());
//		for(WebElement ele: liChk)
//		{
//			ele.click();
//		}

//		//Select multiple checkboxes
//
//		List<WebElement> liChk1=driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
//		System.out.println(liChk1.size());
//		for(WebElement ele: liChk1)
//		{
//			if(ele.getAttribute("id").equals("monday") || ele.getAttribute("id").equals("sunday"))
//			{
//				ele.click();
//			}
//		}
		
//		//Select last 2 checkboxes
//		List<WebElement> liChk2=driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
//		System.out.println(liChk2.size());
//		for(int i=liChk2.size()-2; i<liChk2.size();i++)
//		{
//			liChk2.get(i).click();
//		}
		
		//Select first 2 checkboxes
				List<WebElement> liChk3=driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
				System.out.println(liChk3.size());
				for(int i=0; i<liChk3.size();i++)
				{
					if(i<2)
					{
						liChk3.get(i).click(); 
					}
				}
	}

}
