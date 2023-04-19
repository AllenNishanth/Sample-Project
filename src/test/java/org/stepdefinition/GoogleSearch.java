package org.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearch {
WebDriver driver;
@Given("user is entring https://www.google.co.in/")
public void user_is_entring_https_www_google_co_in() {   
	WebDriverManager.chromedriver().setup();
    driver= new ChromeDriver();
    driver.get("https://www.google.co.in/");
}

@Given("user is typing the search term {string}")
public void user_is_typing_the_search_term(String string) {
   driver.findElement(By.name("q")).sendKeys(string);
}

@When("Enter the return key")
public void enter_the_return_key() {
	 driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
  
}

@Then("user should see the search result")
public void user_should_see_the_search_result() {
	boolean displayed = driver.findElement(By.partialLinkText("iphon")).isDisplayed();
	if(displayed) {System.out.println("done");}
   
}


}
