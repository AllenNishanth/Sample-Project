package org.webpagehandle;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Adactinbrowser {
	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\Admin\\OneDrive\\Desktop\\ecplise\\SeleniumProjects\\NewDriver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	//driver.navigate().to("https://adactinhotelapp.com/");
	driver.get("https://adactinhotelapp.com/");
	driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	WebElement user = driver.findElement(By.id("username"));
	user.sendKeys("Andrew07");
	WebElement passkey = driver.findElement(By.id("password"));
	passkey.sendKeys("UN45LL");
//	WebElement clk = driver.findElement(By.id("login"));
//	clk.click();
}}
