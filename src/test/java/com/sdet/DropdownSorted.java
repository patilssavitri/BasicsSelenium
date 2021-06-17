package com.sdet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownSorted {
	
	@Test
	public void dropdownsortTest()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.twoplugs.com/");
		driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
		//driver.findElement(By.xpath("//a[@href='/newsearchserviceneed']")).click();
		WebElement selObj=driver.findElement(By.xpath("//select[@name='category_id']"));
		Select selOptObj=new Select(selObj);
		List<WebElement> liDrop=selOptObj.getOptions();
		ArrayList<String> orgList=new ArrayList<String>();
		ArrayList<String> tempList=new ArrayList<String>();
		
		for(WebElement opt: liDrop)
		{
			orgList.add(opt.getText());
			tempList.add(opt.getText());
		}
		System.out.println("original list " + orgList);
		System.out.println("Temp list " + tempList);
		Collections.sort(tempList);
		System.out.println("After sort");
		System.out.println("original list " + orgList);
		System.out.println("Temp list " + tempList);
		
		if(orgList.equals(tempList))
		{
			System.out.println("Sorted");
		}
		else
		{
			System.out.println("Unsorted");
		}
		driver.quit();
	}
	
}
