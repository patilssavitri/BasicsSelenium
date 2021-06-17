package com.sdet;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropdown {
	
	@Test
	public void selectDropdownvalue()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.opencart.com/index.php?route=account/register");
		WebElement selObj= driver.findElement(By.xpath("//select[@id='input-country']"));
		
		Select drpdountyElm= new Select(selObj);
		drpdountyElm.selectByVisibleText("Denmark");
		drpdountyElm.selectByValue("66");
		drpdountyElm.selectByIndex(4);
		
		
		//Selecting option without using method
		List<WebElement> allOptions=drpdountyElm.getOptions();
		
		for(WebElement ele : allOptions)
		{
			if(ele.getText().equals("Cuba"))
			{
				ele.click();
				break;
			}
		}
	
		
		//*******************Handle multiple dropdowns 
		
		
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		Select S1=new Select(driver.findElement(By.id("Form_submitForm_NoOfEmployees")));
		S1.selectByValue("21 - 25");
		
		Select S2=new Select(driver.findElement(By.id("Form_submitForm_Industry")));
		S2.selectByValue("Agriculture/Forestry");
		
		Select S3=new Select(driver.findElement(By.id("Form_submitForm_Country")));
		S3.selectByValue("Australia");
		
		WebElement SO1=driver.findElement(By.id("Form_submitForm_NoOfEmployees"));
		slectdropdwn(SO1,"1,001 - 1,500");
		WebElement SO2=driver.findElement(By.id("Form_submitForm_Industry"));
		slectdropdwn(SO2,"Healthcare");
		WebElement SO3=driver.findElement(By.id("Form_submitForm_Country"));
		slectdropdwn(SO3,"Belgium");
	}
	
	public static void slectdropdwn(WebElement eleObj, String value)
	{
		Select sEle= new Select(eleObj);
		List<WebElement> lsobj=sEle.getOptions();
		for(WebElement EOption: lsobj)
		{
			if(EOption.getText().equals(value))
			{
				EOption.click();
				break;
			}
		}
	}
	
	

}
