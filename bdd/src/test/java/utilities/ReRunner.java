package utilities;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "@target/failed_scenarios.txt", 
		glue={"stepDefinitions"}, //the path of the step definition files
		plugin= {"pretty","html:target/HTML_reports_rerun.html", "json:target/cucumber/cucumber.json", "junit:target/cucumber.xml"}, //to generate different types of reporting
		monochrome = true, //display the console output in a proper readable format
		dryRun = false		
		)

public class ReRunner {
}