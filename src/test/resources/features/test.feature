Feature: This is a test feature

  Scenario: open google and search something
    Given open google url: https://www.google.com/
    When input selenium on search box
    Then I am on search results page
