#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
#@tag


#---------------------**********************************-------------------------------------------
# To test the following features/scenario for adidas home page

Feature: Adidas Home Page Verification feature

@TC_001
Scenario: To verify the Adidas Home page is displayed 

Given navigate to web site
Then user verifies home page is displayed

@TC_002
Scenario: To verify the display of Men Section

Given navigate to web site
Then user verifies home page is displayed
Then verify Men drop down is displayed on Home Page

@TC_003
Scenario: To verify the display of Women Section

Given navigate to web site
Then user verifies home page is displayed
Then verify Women drop down is displayed on Home Page

@TC_004
Scenario: To verify the display of Sports Section

Given navigate to web site
Then user verifies home page is displayed
Then verify Sports drop down is displayed on Home Page

@TC_005
Scenario: To verify the display of Brands Section

Given navigate to web site
Then user verifies home page is displayed
Then verify Brands drop down is displayed on Home Page

