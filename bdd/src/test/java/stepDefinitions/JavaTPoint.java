package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import utilities.BaseClass;
import webElements.JavaTPointElements;

public class JavaTPoint {

	static BaseClass baseClass = new BaseClass();

	@Given("I want to visit javatpoint website")
	public void i_want_to_visit_javatpoint_website() {
		baseClass.setupBrowser();
		baseClass.launchURI_2();
	}


	@Given("I click on Python tutorial link")
	public void some_click_on_python_tutorial_link() {	
		baseClass.elementClickEvent(JavaTPointElements.python_link);
		baseClass.assertIntegers(1,1, "JavaTPoint");
	}


	@Given("I want to visit Google Maps website")
	public void i_want_to_visit_google_maps_website() {
		baseClass.setupBrowser();
		baseClass.launchURI_3();
		baseClass.assertIntegers(1,1, "JavaTPoint");
	}

	@After
	public void afterScenario(Scenario scenario) {
		//		if(scenario.isFailed()) {
		//		}
		baseClass.closeDriver();
	}
}
