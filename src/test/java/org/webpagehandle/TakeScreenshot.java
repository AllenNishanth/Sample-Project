package org.webpagehandle;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenshot {
public static void main(String[] args) throws IOException {
WebDriverManager.chromedriver().setup();
WebDriver driver = new ChromeDriver();
driver.get("https://www.facebook.com/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
TakesScreenshot ss= (TakesScreenshot)driver;
WebElement element = driver.findElement(By.xpath("//img[@class='fb_logo _8ilh img']"));
File source = element.getScreenshotAs(OutputType.FILE);
File target=new File("C:\\Users\\Admin\\OneDrive\\Desktop\\ecplise\\MavenNish\\Screenshot\\Facebook.png");
FileUtils.copyFile(source, target);
      
}
}
