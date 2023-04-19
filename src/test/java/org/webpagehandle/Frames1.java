package org.webpagehandle;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames1 {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://netbanking.hdfcbank.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	int size = driver.findElements(By.tagName("frame")).size();
	System.out.println(size);
	WebElement element = driver.findElement(By.xpath("//frame[@name='login_page']"));
	driver.switchTo().frame(element);
	WebElement cusId = driver.findElement(By.xpath("//input[@name='fldLoginUserId']"));
	cusId.sendKeys("asdfh");
	WebElement conBtn = driver.findElement(By.xpath("//a[@class='btn btn-primary login-btn']"));
conBtn.click();

}
}
