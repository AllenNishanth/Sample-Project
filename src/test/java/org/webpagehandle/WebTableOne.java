package org.webpagehandle;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebTableOne {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\OneDrive\\Desktop\\ecplise\\SeleniumProjects\\NewDriver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		// driver.get("https://money.rediff.com/gainers");
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement table = driver.findElement(By.id("customers"));
		List<WebElement> allrow = table.findElements(By.tagName("tr"));
		for (int i = 0; i < allrow.size(); i++) {
			WebElement row = allrow.get(i);
			String text = row.getText();
			 System.out.println(text);
			System.out.println();

			List<WebElement> data = row.findElements(By.tagName("td"));
			for (int j = 0; j < data.size(); j++) {
				WebElement webElement = data.get(j);
				String text2 = webElement.getText();
				System.out.println("Data =" + text2);
			}
		}

	}
}