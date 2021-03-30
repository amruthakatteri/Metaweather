Feature: Weather for Location and Date
  Users should be able to verify weather forecast APIs like for a given city and date
  Scenario_001 Location Day - Verify weather forcast for a given city and date
  Scenario_002 Location - Verify n days weather forecast for a given city
  Both the tests internally use "Location Search" API to fetch the WOEID for given city
  Scenario_003 Location Search - Verify woeid not returned for invalid city
  Scenario_004 Location Search - Verify multiple WOEID is returned corresponding to cities with same name in different locations
  Scenario_005 Location Search - Verify multiple WOEID is returned corresponding to cities having given city name as substring
  

 	@SmokeTest
  Scenario: 001 Verify the weather state for London for next few days  
    When I verify the weather forecast for 'London' for Today is 'Heavy Cloud' 
	    And I verify the weather forecast for 'London' for 1 days from Today is 'Showers'
	    And I verify the weather forecast for 'London' for 2 days from Today is 'Clear'
	    And I verify the weather forecast for 'London' for 3 days from Today is 'Light Cloud'
    
  @SmokeTest
  Scenario: 002 Verify weather forecast is available for London for next n number of days 
    When I verify the 6 days weather forecast including Today is returned for 'London'
   