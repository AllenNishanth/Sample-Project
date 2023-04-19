package org.pageobject;

import java.io.IOException;

import org.baseclass.AdactinBaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogIn extends AdactinBaseClass {
	public LogIn() {
	PageFactory.initElements(driver,this);
	}
	@FindBy(id="username")
	private WebElement userName;
	@FindBy(id="password")
	private WebElement PassWord;
	@FindBy(id="login")
	private WebElement logIn;
	
	public WebElement getUserName() {
		return userName;
	}
	public WebElement getPassWord() {
		return PassWord;
	}
	public WebElement getLogIn() {
		return logIn;
	}
	
	
	public static void adactiLogIn() throws IOException {
	String data = getData("Nishanth", 1, 0);
	System.out.println(data);
	
		
//	String data = getData("Nishanth", 1, 0);
//	userName.sendKeys(data);
//	String data2 = getData("Nishanth", 1, 1);
//	PassWord.sendKeys(data2);
//	logIn.click();

}
	
	}
	

	
	
	
	
