@regression_All
Feature: react Js ui test case

@tc01_UI_reactJs
 Scenario: React js submenu validation
    Given Navigate to React JS site "https://legacy.reactjs.org/"
    When Click on Docs Tab
    And Expand the main Concepts and highlight all the sub elements or link references and get the text dynamically and save it in file
		And Similarly Do it for Advanced Guides Tab also
		
@tc02_UI_reactJs
Scenario: ReactJs validate scroll function
 Given Navigate to React JS site "https://legacy.reactjs.org/"
 And Verify Scroll Functionality in tutorial tab
 Then On scrolling down, verify the respected content is Bolded on Right Navigation and Blue color line is seen

 
