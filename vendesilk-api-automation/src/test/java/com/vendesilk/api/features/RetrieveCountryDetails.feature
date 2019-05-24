Feature: Retrieve Country Details Feature
  As a user I should be able retrieve the country details from a web service and verify them

  @Smoke
  Scenario: Get all countries and validate US, DE and GB are returned in the response
    Given The webservice is up and running
    When User wants to get information for all countries
    Then the response code should be "200"
    And the response should be returned in a valid JSON format
    And the returned response should include the following countries
      | US |
      | GB |
      | DE |


  @Smoke
  Scenario Outline: Get each country (US, DE and GB) individually and validate the response
    Given The webservice is up and running
    When User wants to get the response for country "<alpha2_code>"
    Then the response code should be "200"
    And the returned response should include "<name>", "<alpha2_code>", and "<alpha3_code>"
    Examples:
      | name                                                 | alpha2_code | alpha3_code |
      | United States of America                             | US          | USA         |
      | United Kingdom of Great Britain and Northern Ireland | GB          | GBR         |
      | Germany                                              | DE          | DEU         |


  @Smoke
  Scenario: Try to get information for not exist countries and validate the response
    Given The webservice is up and running
    When User wants to get information for unexisted country: "USX"
    Then the response code should be "200"
    And a message should be returned saying "USX" not found
    But no results should be returned


  @Smoke
  Scenario: Add a new country through POST request and validate the response
    Given The webservice is up and running
    When User wants to add a new country: "Test Country", "TC", "TCY"
    Then the response code should be "201"