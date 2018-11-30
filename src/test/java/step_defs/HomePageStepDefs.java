package step_defs;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.HomePage;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ExcelUtil;

public class HomePageStepDefs {
	
		HomePage homePage = new HomePage();
		WebDriver driver = Driver.getDriver();
		ExcelUtil excel = new ExcelUtil("src/test/resources/com/test-data/CreditCards.xlsx", "Sheet1");

		@Given("user will go to the homepage")
		public void user_will_go_to_the_homepage() {
			driver.get(ConfigurationReader.getProperty("url"));
		}

		@Then("verify if the title includes {string}")
		public void verify_if_the_title_includes(String title) {
			assertTrue(driver.getTitle().trim().contains(title));
		}

		@Then("verify the header {string}")
		public void verify_the_header(String headerText) {
			String actual = homePage.header.getText().trim();
			String expected = headerText;
			System.out.println(actual);
			assertTrue(actual.contains(expected));

		}

		@Then("verify the Categories {string} displayed under Whats your credit score")
		public void verify_the_Categories_displayed_under_Whats_your_credit_score(String string) {
			List<String> actual = load(homePage.creditRates);
			List<String> expected = excel.loadOnlyRow(0);
			assertEquals(expected, actual);
		}

		@Then("User clicks on Excellent tab in - What's your credit core")
		public void user_clicks_on_Excellent_tab_in_What_s_your_credit_core() {
			homePage.excellentTab.click();
		}

		@Then("verify if the title of tab is {string}")
		public void verify_if_the_title_of_tab_is(String string) {
			String expected = string;
			String actual = homePage.excellentTabHeader.getText();
			assertEquals(expected, actual);
		}

		@Then("Verify all the tabs {string} are available")
		public void verify_all_the_tabs_are_available(String string) {
			List<String> actualFeatutes = load(homePage.listOfFeaturesinExcellent);

			System.out.println(actualFeatutes);
			List<String> expectedFeatures = excel.loadOnlyRow(1);
			assertEquals(expectedFeatures, actualFeatutes);
		}

		@Then("verify that the top ribbon menu is visible")
		public void verify_that_the_top_ribbon_menu_is_visible() {
			boolean ribbonMenuDisplayed = homePage.ribbonMenu.isDisplayed();
			assertTrue(ribbonMenuDisplayed);
		}

		@Then("verfiy all menu {string} are available in the main menu")
		public void verfiy_all_menu_are_available_in_the_main_menu(String string) {
			List<String> actual = load(homePage.menuItems);
			List<String> expected = excel.loadOnlyRow(2);
			assertEquals(expected, actual);
		}

		@Then("User should hover on the menu item {string}")
		public void user_should_hover_on_the_menu_item(String string) {
			List<String> menuItems = load(homePage.menuItems);
			int indexOfElement= getIndexOnTheElement(menuItems, string);
			BrowserUtils.hover(homePage.menuItems.get(indexOfElement));
		}

		
		@Then("verfiy if all the items are displayed in tools menu Item")
		public void verfiy_if_all_the_items_are_displayed_in_tools_menu_Item() {
			List<String> actual= load(homePage.listOfMenuItemsInTools);
			List<String> expected= excel.loadOnlyRow(3);
			assertEquals(expected, actual);
		}
		
		
		/*
		 * Following method will return the index of the searched String
		 * 
		 * */
		
		public int getIndexOnTheElement(List<String> menuItems, String string) {
			for (int i = 0; i < menuItems.size(); i++) {
				if(menuItems.get(i).equals(string)) {
					return i;
				}
					
			}
			return -1;

		}

		

		/*
		 * This method converts all the webElements in a list into a list of strings
		 * 
		 * @param : list of WebElements
		 * 
		 * @returns : list of Strings
		 * 
		 * 
		 */
		public List<String> load(List<WebElement> list) {
			List<String> result = new ArrayList<String>();
			for (int i = 0; i < list.size(); i++) {
				result.add(list.get(i).getText().trim());
			}
			return result;

		}

	}

	
	

