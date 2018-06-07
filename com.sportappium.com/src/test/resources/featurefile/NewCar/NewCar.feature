Feature: To verify scenarios related with New Car functionality


@TC_001
Scenario: Verify the New Car button on home page and user routes to correct page after clicking it

Given navigate to web site
Then user verifies home page is displayed
And verify New Car button is displayed on the home page
Then click on New Car button
Then Verify select a category page is displayed

@TC_002
Scenario: Verify the results on the basis of new car brand name

Given navigate to web site
Then user verifies home page is displayed
And verify New Car button is displayed on the home page
Then click on New Car button
Then Verify select a category page is displayed
And Click on Search New Car button
Then Verify Search New Car page is displayed
And Click on Maruti button under Brands section
Then Verify that Maruti module is selected
And Click on Search button
Then Verify Search result page specific to Maruti is displayed
And Verify first search page should contain only maruti cars results only
Then scroll to bottom and click on Next button
Then Verify Search result page specific to Maruti is displayed
And Verify next search page should contain only maruti cars results only
Then scroll to bottom and click on Next button
Then Verify Search result page specific to Maruti is displayed
And Verify next search page should contain only maruti cars results only



@TC_003
Scenario: Verify the Used Car button on home page and user routes to correct page after clicking it

Given navigate to web site
Then user verifies home page is displayed
And verify Used Car button is displayed on the home page
Then click on Used Car button
Then Verify Used Car page is displayed





























@TC_0
Scenario: Verify Budget and All vehicle type drop down values for New Car for By Budget option 

Given navigate to web site
Then user verifies home page is displayed
And verify New Car tab is selected by default
And Verify By Budget radial button is selected by default
And verify default value of budget drop down
And verify default value of vehicle type drop down
And verfiy the values for Budget drop down values
And verfiy the values for Vehicle drop down values

@TC_0

Scenario: Verify search results on the basis of budget value for New Car for By Budget option 
Given navigate to web site
Then user verifies home page is displayed
And verify New Car tab is selected by default
And Verify By Budget radial button is selected by default
And verify default value of budget drop down
And verify default value of vehicle type drop down
And verfiy the values for Budget drop down values
And verfiy the values for Vehicle drop down values
And select budget value from Select Budget drop down
And select vehicle type from All Vehicle Types drop down
And click on search button
And verify that required next page is displayed


@TC_
Scenario: Verify New Car button on the Android Web App
Given navigate to web site
Then verify New Cars button

