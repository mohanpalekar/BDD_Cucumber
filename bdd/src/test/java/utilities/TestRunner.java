package utilities;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/feature",
		glue={"stepDefinitions"},
		//		monochrome = true,
		plugin = {"pretty", "html:target/HTML_reports.html", "rerun:target/failed_scenarios.txt"},
		dryRun = false,
		tags="@tag11"
		)

public class TestRunner {

}