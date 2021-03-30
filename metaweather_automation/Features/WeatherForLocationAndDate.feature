@FunctionalTest
Feature: Weather for Location and Date
  Users should be able to verify weather forecast APIs for a given city and date
  Scenario_001 Testing "Location Day" API and internally use "Location Search" API to fetch the WOEID for given city
  Scenario_002 Testing "Location" API and internally use "Location Search" API to fetch the WOEID for given city
  Scenario_003,Scenario_004,Scenario_005 Testing "Location Search" API

		@RegressionTest
  	Scenario: 001 Verify the weather state for London for next few days  
   		When I verify the weather forecast for 'London' for Today is 'Heavy Cloud' 
		    And I verify the weather forecast for 'London' for 1 days from Today is 'Showers'
		    And I verify the weather forecast for 'London' for 2 days from Today is 'Clear'
		    And I verify the weather forecast for 'London' for 3 days from Today is 'Light Cloud'
    
		@RegressionTest
		Scenario: 002 Verify weather forecast is available for London for next n number of days 
			When I verify the 6 days weather forecast including Today is returned for 'London'
   
		@RegressionTest
		Scenario: 003 Verify multiple WOEIDs are returned corresponding to cities with same name in different locations (eg:Manchester)
			When I verify multiple WOEIDs are returned if the city name is 'Manchester'
    
		@RegressionTest
		Scenario: 004 Verify WOEID not returned for invalid city 
			When I verify WOEID is not returned for invalid city 'XYZ'
    
		@RegressionTest
		Scenario: 005 Verify whether WOEID is returned for an invalid cityname which occurs as a substring in many valid city names(eg: Don)
			When I verify WOEID is returned if the city name is 'Don' which occurs as a substring in many city names.
			
		@ManualTest_LocationApi
		Scenario: 006 Verify whether the top most "applicable_date" fields in the location Api response is populated with current date and the subsequent 5 "applicable_date" fields are populated with 5 consecutive days from today

		@ManualTest_LocationApi
		Scenario: 007 Verify whether the response fields of location Api by comparing against the REST API Doc

		@ManualTest_LocationApi
		Scenario: 008 Verify whether the country name populated in the "title" field of the location Api response corresponds to provided WOEID.

		@ManualTest_LocationApi
		Scenario: 009 Verify whether the "detail" field in the response of location Api is populated wiith string "Not found" by giving invalid WOEID.eg:00000

		@ManualTest_LocationDayApi
		Scenario: 010 Verify whether the Location Day API returns response with weather data for past dates,current date and only for next 8 days.
			
		
    
    
    
    
   