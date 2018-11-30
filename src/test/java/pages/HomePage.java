package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class HomePage {
	
	public HomePage() {
			PageFactory.initElements(Driver.getDriver(), this);
		}
		
		// following line finds all 5 of the menu items
		@FindBy (xpath="//ul[@class='menu']//li[@class='menu__item']")
		public List<WebElement> menuItems;
		
		@FindBy(xpath= "//h1[@class='homePage-hero__headline']" )
		public WebElement header;
		
		@FindBy(xpath="//label[@for='excellent']")
		public WebElement excellentTab;
		
		@FindBy(xpath="//div[@class='cardFinder__tabContainer']//label/strong")
		public List<WebElement> creditRates;
		
		@FindBy(xpath="//div[@class='cardFinder__tabContent cardFinder__tabContent--excellent']//h3[@class='cardFinder__title cardFinder__title--bottom']")
		public WebElement excellentTabHeader;
		
		@FindBy(xpath="//div[@class='cardFinder__tabContent cardFinder__tabContent--excellent']//label")
		public List<WebElement> listOfFeaturesinExcellent; 
		
		@FindBy(xpath="//ul[@class=\"menu\"]")
		public WebElement ribbonMenu;
		
		@FindBy(xpath="(//a[.='Tools']/..)//li[@class='menu__link']")
		public List<WebElement> listOfMenuItemsInTools;
		

	}

	
	

