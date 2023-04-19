package org.webpagehandle;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Select11 {
	public static void main(String[] args) {
		
WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://adactinhotelapp.com/");
	driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	WebElement user = driver.findElement(By.id("username"));
	user.sendKeys("Andrew07");
	WebElement passkey = driver.findElement(By.id("password"));
	passkey.sendKeys("UN45LL");
	WebElement clk = driver.findElement(By.id("login"));
	clk.click();
	WebElement location = driver.findElement(By.xpath("//select[@name='location']"));
	Select one = new Select( location);
	List<WebElement> options = one.getOptions();
	for (int i = 0; i < options.size(); i++) {
		WebElement webElement = options.get(i);
		String text = webElement.getText();
		System.out.println(text);
	}

	for (WebElement webElement : options) {
	String text = webElement.getText();
		System.out.println(text);
	}
	
	
	
	
	
}
}