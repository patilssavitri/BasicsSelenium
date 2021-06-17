package com.sdet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class LaunchBrowser {

	@Test
	public void launchBrowser() {
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shwetha\\Desktop\\savitrip\\MyWork\\chromedriver_win32\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getPageSource());
		//isDisplayed() isEnabled()
		System.out.println(driver.findElement(By.name("q")).isDisplayed());
		System.out.println(driver.findElement(By.name("q")).isEnabled());
		
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\shwetha\\Desktop\\savitrip\\MyWork\\geckodriver-v0.29.1-win32\\geckodriver.exe");
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver1= new FirefoxDriver();
		driver1.get("https://www.google.com");
		System.out.println(driver1.getTitle());
		System.out.println(driver1.getCurrentUrl());
		System.out.println(driver1.getPageSource());
		System.out.println(driver1.findElement(By.name("q")).isDisplayed());
		System.out.println(driver1.findElement(By.name("q")).isEnabled());
		
//		System.setProperty("webdriver.edge.driver", "C:\\Users\\shwetha\\Desktop\\savitrip\\MyWork\\edgedriver_win64\\msedgedriver.exe");
		WebDriverManager.edgedriver().setup();
		WebDriver driver2 = new EdgeDriver();
		driver2.get("https://www.google.com");
		System.out.println(driver2.getTitle());
		System.out.println(driver2.getCurrentUrl());
		System.out.println(driver2.getPageSource());
		System.out.println(driver2.findElement(By.name("q")).isDisplayed());
		System.out.println(driver2.findElement(By.name("q")).isEnabled());
				
	}


}
