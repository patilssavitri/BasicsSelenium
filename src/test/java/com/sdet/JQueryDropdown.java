package com.sdet;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JQueryDropdown {

	@Test
	public void jqueryDropdwnSelectTest()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		
		driver.findElement(By.xpath("(//span[@class='comboTreeArrowBtnImg'])[1]")).click();
		try
		{
		selectOptions(driver,"all");
		}
		catch(Exception e)
		{
			System.out.println(e.getStackTrace());
		}
		driver.findElement(By.xpath("(//span[@class='comboTreeArrowBtnImg'])[2]")).click();
		selectOptions(driver,"choice 2","choice 3");
		driver.findElement(By.xpath("(//span[@class='comboTreeArrowBtnImg'])[3]")).click();
		selectOptions(driver,"choice 2","choice 2 1","choice 6 1");
	}

	public static void selectOptions(WebDriver driver,String...value)
	{
		List<WebElement> listEle=driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
		if(!(value[0].equals("all")))
		{
			for(WebElement opt: listEle)
			{
				for(String item:value)
				{
					if(opt.getText().equals(item))
					{
						opt.click();
						break;
					}
				}
			}
		}
		else
		{
			for(WebElement opt: listEle)
			{
				opt.click();
			}
		}
	}

}
