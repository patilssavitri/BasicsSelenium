package com.sdet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Winhandle {
	@Test
	public void WindowHandlesTest() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		System.out.println(driver.getWindowHandle());
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
		Set<String> handSet=driver.getWindowHandles();
		System.out.println(handSet.size());
		
		//First method - using Iterator
		Iterator<String> it=handSet.iterator();
		String winID;
		while(it.hasNext())
		{
			winID=it.next();
			driver.switchTo().window(winID);
			System.out.println(winID);
			System.out.println(driver.getTitle());
			Thread.sleep(3000);
		}
		
		//Second method - using List/arrayList
		
		List<String> WinList=new ArrayList<String>(handSet);
		for(String id:WinList)
		{
			
			driver.switchTo().window(id);
			System.out.println(id);
			System.out.println(driver.getTitle());
			Thread.sleep(3000);
		}
		driver.quit();
	
	}

}
