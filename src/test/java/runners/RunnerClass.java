package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {
				"pretty",
				"html:target/default-cucumber-reports", //generates every time we run the cukes runner
				"json:target/cucumber.json",
				"junit:target/cucumber.xml"
		
		},
		
		tags="@sample",
		features= {"src/test/resources/"}, 
		glue= {"step_defs" }
		,dryRun = false
		)


public class RunnerClass {}
