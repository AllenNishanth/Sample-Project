package org.webpagehandle;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsHandle {
	private static final TimeUnit SECONDS = null;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("oneplus");
		WebElement searchLens = driver.findElement(By.id("nav-search-submit-button"));
		searchLens.click();
		String parentWindow = driver.getWindowHandle();

		List<WebElement> mobs = driver
				.findElements(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])"));
		for (int i = 0; i < mobs.size(); i++) {
			WebElement webElement = mobs.get(i);
			webElement.click();
			String text = webElement.getText();
			System.out.println(text);
			
			Set<String> handles = driver.getWindowHandles(); 
		for (String newWindow : handles) {
				driver.switchTo().window(newWindow);
				
			}
		 //System.out.println((handles.size()));
			WebElement addcart = driver.findElement(By.xpath("//input[@name='submit.add-to-cart']"));
			addcart.click();
			driver.switchTo().window(parentWindow);
			//driver.close();
			if(i>=handles.size()) {
			driver.switchTo().defaultContent();
	
		}
		
		}

	}}



