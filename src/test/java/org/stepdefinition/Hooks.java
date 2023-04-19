package org.stepdefinition;

import org.baseclass.AdactinBaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends AdactinBaseClass {
	@Before
	public void beforeTheScenario() {
	launch(Url, 30);

}
	
	@After
	public void afterTheScenario() {
	//	close();
}
}