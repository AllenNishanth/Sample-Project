package org.stepdefinition;

import java.io.IOException;

import org.pageobject.LogIn;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReSetButton {
	@Given("User giving valid username and Password")
	public void user_giving_valid_username_and_Password() throws Exception {
	   LogIn log = new LogIn();
	   log.adactiLogIn();
	}

	@Given("user click the login Button")
	public void user_click_the_login_Button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Given("the user verify the search hotel is verify or not with the reset Button")
	public void the_user_verify_the_search_hotel_is_verify_or_not_with_the_reset_Button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("the user enter the valid details in the given field")
	public void the_user_enter_the_valid_details_in_the_given_field() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("User click on the reset button")
	public void user_click_on_the_reset_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}
	@Then("the entered values change to default value")
	public void the_entered_values_change_to_default_value() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}  
}
	