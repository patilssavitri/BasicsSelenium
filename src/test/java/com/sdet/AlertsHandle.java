package com.sdet;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsHandle {
	@Test
	public void alertTest() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		System.out.println(driver.findElement(By.id("result")).getText());
		
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();
		System.out.println(driver.findElement(By.id("result")).getText());
		
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		System.out.println(driver.findElement(By.id("result")).getText());
		
		
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
	Alert al=driver.switchTo().alert();
	System.out.println(al.getText());
		Thread.sleep(3000);
		al.sendKeys("testing");
		Thread.sleep(3000);
		al.accept();
		System.out.println(driver.findElement(By.id("result")).getText());
		driver.quit();
	}

}
