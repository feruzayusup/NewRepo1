package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class Home {
	
		public Home() {
			PageFactory.initElements(Driver.getDriver(), this);
		}
		
		@FindBy(xpath="//a[.='Log In'][1]")
		public WebElement loginLink;
		
		@FindBy(xpath="//a[.='Schwab.com']")
		public WebElement schwabLink;
		
		@FindBy(id="LoginId")
		public WebElement userName;
		
		@FindBy(id="Password")
		public WebElement password;
		
		@FindBy(id="StartIn")
		public WebElement dropDown;
		
		@FindBy(id="LoginText")
		public WebElement loginButton;
		

	}

	
	