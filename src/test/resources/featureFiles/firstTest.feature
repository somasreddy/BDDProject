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
@tagLoginFeature
Feature: Login feature Test
  I want to use this template to test my login feature

  @tagLoginTest
  Scenario Outline: To search test tools on Google
    When I enter pageUrl "https://www.softest-training.com/index.php"
    And I click on StudentLogin Link
    Then I should see Login page
    When I enter username "<username>"
    And I enter password  "<password>"
    And I click submit button
    When Credentials are wrong Error should be displayed
    When Credentials are correct student homepage to be displayed
    When I click on Logout link
    Then I should be in home page

    Examples: 
      | username   | password  |
      | somasekhar | nani      |
      |        123 | abc       |
      | abc        | naniki143 |
      | somasekhar | naniki143 |
