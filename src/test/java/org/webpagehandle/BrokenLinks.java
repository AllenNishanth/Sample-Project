package org.webpagehandle;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {
public static void main(String[] args) throws IOException {
	//if its a broken link response is 404 error 
	WebDriverManager.chromedriver().setup();
	WebDriver driver =new ChromeDriver();
	driver.get("https://amazon.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//1)capture links
	//2)count number of links
	// a is the anchor tag capture all a
	
	List<WebElement> links = driver.findElements(By.tagName("a"));
	
	System.out.println(links.size());
	
	for (int i = 0; i < links.size(); i++) {
		WebElement element = links.get(i);
		String url = element.getAttribute("herf");
		
		URL link= new URL(url);
		//create connection using url 
		HttpURLConnection httpcon =(HttpURLConnection)link.openConnection();
		httpcon.connect();
		int responseCode = httpcon.getResponseCode();
		if(responseCode>=400) {
			System.out.println(url+"broken link");
		}else {
				System.out.println(url+"normal link");
			}
		}
	}
	
	
	
	
	
}

