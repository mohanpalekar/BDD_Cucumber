package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.BaseClass;
import webElements.w3schools;

public class W3School {

	static BaseClass baseClass = new BaseClass();

	@Given("I want to visit W3School site")
	public void step_impl1 () {
		baseClass.setupBrowser();
		baseClass.launchURI();
		baseClass.elementClickEvent(w3schools.searchButton);
	}

	@Given("I enter the search string")
	public void step_impl2() {
		baseClass.enterInput(w3schools.searchBar, "Python");
	}

	@Then("I press submit button")
	public void step_impl3() throws InterruptedException {
		baseClass.pressEnterButton(w3schools.searchBar);
		Thread.sleep(500);	
		baseClass.launchURI();
		baseClass.assertIntegers(1,1, "W3School");
	}

	@After
	public void afterScenario(Scenario scenario) {
		baseClass.closeDriver();
	}

}
