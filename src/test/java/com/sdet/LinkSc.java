package com.sdet;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkSc {
	
	@Test
	public void LickTest() throws MalformedURLException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
//		driver.findElement(By.linkText("Today's Deals")).click();
		
//		driver.findElement(By.partialLinkText("Today's")).click();
		
		//all links
		List<WebElement> linkList=driver.findElements(By.tagName("a"));
		System.out.println("num of links "+ linkList.size());
		
		for(int i=0;i<linkList.size();i++)
		{
			System.out.println(linkList.get(i).getText());
			System.out.println(linkList.get(i).getAttribute("href"));
		}
		
		//broken links
		driver.get("http://www.deadlinkcity.com/");
		List<WebElement> liLink=driver.findElements(By.tagName("a"));
		int brokenlink;
		brokenlink=0;
		for(WebElement link : liLink)
		{
			String url=link.getAttribute("href");
			if(url==null||url.isEmpty())
			{
				System.out.println("URL is empty");
				continue;
			}
			URL link1=new URL(url);
			try
			{
			HttpURLConnection conn=(HttpURLConnection)link1.openConnection();
			conn.connect();
			if(conn.getResponseCode()>=400)
			{
				System.out.println(conn.getResponseCode() + " is broken link");
				brokenlink++;
			}
			else
			{
				System.out.println(conn.getResponseCode() + " is valid link");
			}
			}
			catch(Exception e)
			{
				
			}
		}
	}

}
