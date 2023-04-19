package org.stepdefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LogInAdactin {
	WebDriver driver;
	@Given("User is entering https:\\/\\/adactinhotelapp.com\\/")
	public void user_is_entering_https_adactinhotelapp_com() {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverManager.chromedriver().setup();
	    driver= new ChromeDriver();
	    driver.get("https://adactinhotelapp.com/");
	    driver.manage().window().maximize();
	}
   /* Normally passing a string in parameter*/
//	@When("user enters {string} {string}")
//	public void user_enters(String string, String string2) {
//		 driver.findElement(By.id("username")).sendKeys(string);
//		 driver.findElement(By.id("password")).sendKeys(string2);
//	}
	
     /*DATA Table*/	
//	@When("user enters the data")
//	public void user_enters_the_data(io.cucumber.datatable.DataTable dataTable) {
//		List<String> asList = dataTable.asList();
//		String string = asList.get(0);
//		String string2 = asList.get(1);
//		 driver.findElement(By.id("username")).sendKeys(string);
//		 driver.findElement(By.id("password")).sendKeys(string2);
//	}
	
	/*Data table with HEADER*/
	@When("end user enters the data")
	public void end_user_enters_the_data(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> asMaps = dataTable.asMaps(String.class, String.class);
		String user = asMaps.get(0).get("userName");
		String pass = asMaps.get(0).get("Password");
		
		driver.findElement(By.id("username")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys(pass);
		
	}

//	@When("end user uses multiple data {string} {string}")
//	public void end_user_uses_multiple_data(String string, String string2) {
//		driver.findElement(By.id("username")).sendKeys(string);
//		 driver.findElement(By.id("password")).sendKeys(string2);
//	    
	
//	}
	@When("click LogIn button")
	public void click_LogIn_button() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.id("login")).click();
	}

	@Then("user should see the booking page")
	public void user_should_see_the_booking_page() {
	    // Write code here that turns the phrase above into concrete actions
	   boolean displayed = driver.findElement(By.xpath("//td[text()='Search Hotel '] ")).isDisplayed();
	   String expected="Search Hotel ";
	if (displayed==true) {
		System.out.println(expected);
	}else
	{System.out.println("undefined");}
	}
	
}
