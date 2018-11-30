package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class UltimateQaPage {
	
	public UltimateQaPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	//will return list of top menu
	@FindBy (id="top-menu")
	public List<WebElement> topMenu;
	
	
	// will find fake landing page link
	@FindBy (xpath="//a[contains(text(), 'Fake Landing Page')]")
	public WebElement fakeLand;
		
	@FindBy (xpath="//div[@class='et_pb_text_inner']//h1")
	public WebElement learnToCode;
	
	@FindBy (xpath="//a[@itemprop='url']")
	public WebElement videoTutorialButton;
	
	
	@FindBy (xpath="//a[@class='header-nav__link']")
	public WebElement allCoursesLink;
	
	
//	@FindBy (xpath="//input[@type='submit']")
//	public WebElement searchButton;
	
}
