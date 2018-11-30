package step_defs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utilities.ConfigurationReader;
import utilities.Driver;

public class Hooks {
	
	
	@Before
	public void setUp() {
		 Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 String device= ConfigurationReader.getProperty("device");
		 if(device.equals("desktop")) {
			 Driver.getDriver().manage().window().fullscreen();
		 }
		 else if(device.equals("cellPhone")) {
			 Dimension d = new Dimension(480,620);
			 Driver.getDriver().manage().window().setSize(d);
		 }
		 else if(device.equals("tablet")) {
			 Dimension d = new Dimension(800,1280);
			 Driver.getDriver().manage().window().setSize(d);
		 }
		 
		 Driver.getDriver().manage().window().fullscreen();
		 Driver.getDriver().get(ConfigurationReader.getProperty("url"));
	}

	

	@After
	public void tearDown(Scenario scenario) {
		// only takes a screenshot if the scenario fails
		if (scenario.isFailed()) {
			// taking a screenshot
			final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
			// adding the screenshot to the report
			scenario.embed(screenshot, "image/png");
		}
		Driver.closeDriver();
	}

	
}
