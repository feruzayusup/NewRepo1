package step_defs;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.UltimateQaPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ExcelUtil;

public class UltimateQaStepDefs {
	
	UltimateQaPage ulPage = new UltimateQaPage();
	WebDriver driver = Driver.getDriver();
	ExcelUtil excel = new ExcelUtil("src/test/resources/test-data/CreditCards.xlsx", "Sheet1");

	
	
	@Given("User the url of UltimateQA website")
	public void user_the_url_of_UltimateQA_website() {
		driver.get(ConfigurationReader.getProperty("url"));
	
		List<String> actual = load(ulPage.topMenu);
		System.out.println(actual); 
//		List<String> expected = excel.loadOnlyRow(0);
//		assertEquals(expected, actual);
	
	
	}

	@When("the user clicks on Fake Landing Page")
	public void the_user_clicks_on_Fake_Landing_Page() {
		ulPage.fakeLand.click();
		
	  
	}

	@Then("the user should be able to land on Learn To Code Page")
	public void the_user_should_be_able_to_land_on_Learn_To_Code_Page() {
		System.out.println(ulPage.learnToCode.getText());
	    
	}

	@Then("the user will clicks on View Courses Button")
	public void the_user_will_clicks_on_View_Courses_Button() {
	   ulPage.videoTutorialButton.click();
	}

	@Then("the ujser should be able to see All Courses")
	public void the_ujser_should_be_able_to_see_All_Courses() {
	   System.out.println(ulPage.allCoursesLink.getText());
	 //  ulPage.searchButton.click();
	}
	
	
	public List<String> load(List<WebElement> list) {
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			result.add(list.get(i).getText().trim());
		}
		return result;

	}
	
	public int getIndexOnTheElement(List<String> menuItems, String string) {
		for (int i = 0; i < menuItems.size(); i++) {
			if(menuItems.get(i).equals(string)) {
				return i;
			}
				
		}
		return -1;

	}

	


}
