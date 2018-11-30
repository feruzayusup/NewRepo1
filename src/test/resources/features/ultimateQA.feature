@sample
Feature: User will login to the schwab website
	
	Scenario Outline: User will be able to access the schwab site
		Given User go to the website
		Then user will click on the login button
		Then user will click on the schwab.com
		When user enters the "<username>" and "<password>"
		Examples:
		|username	| password|
		|mehmet		| pwd0	  |
	
	@sample
	Scenario: User should be able to access the UltimateQA website
	
	Given User the url of UltimateQA website
	When the user clicks on Fake Landing Page
	Then the user should be able to land on Learn To Code Page
	And the user will clicks on View Courses Button
	Then the ujser should be able to see All Courses	