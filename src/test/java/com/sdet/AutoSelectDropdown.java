package com.sdet;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSelectDropdown {

	@Test
	public void AutoSelectTest() 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//bing
		driver.get("https://www.bing.com");
		driver.findElement(By.id("sb_form_q")).sendKeys("Java Tutorial");
		//		Thread.sleep(3000);
		List<WebElement>liautoSel=driver.findElements(By.xpath("//li[@class='sa_sg']//span"));
		System.out.println(liautoSel.size());

		for(WebElement liOpt: liautoSel)
		{
			if(liOpt.getText().contains("pdf"))
			{
				liOpt.click();
				break;
			}
		}
		driver.close();
	}

	
	@Test
	public void AutoSelectTest2() throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//google
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Selenium");
		Thread.sleep(30);
		List<WebElement>liautoSel1=driver.findElements(By.xpath("//li[@class='sbct']//div[@role='option']//div[@class='wM6W7d']//span/b"));
		System.out.println(liautoSel1.size());

		for(WebElement liOpt: liautoSel1)
		{
			if(liOpt.getText().contains("download"))
			{
				liOpt.click();
				break;
			}
		}
		driver.quit();
	}
}


