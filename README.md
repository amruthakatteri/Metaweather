# Metaweather API Automation

Project to integrate with Metaweather APIs(https://www.metaweather.com/api/) and perform REST API automation testing.


## Getting Started

Use IDEs like Eclipse or IntelliJ to clone and import this project using the below code repository.
https://github.com/amruthakatteri/Metaweather.git

The scope involves testing below 3 APIs

Location Search

Location

Location Day

### Assumptions

Considering the ease of use for business analysts, Location & Location Day API test scenarios in feature file are not taking WOEID as direct input, instead it takes City name as input.
Internally WOEID for the input City name is fetched from Location Search API.

This way all the 3 APIs are tested.

If the requirement is to make this API call frequently for same city, it is worth considering changing the feature file test scenarios to directly use WOEID.
That way 2 API calls can be reduced to 1 API call. 

So the approach is purely dependant on whether we need ease of use of feature file or performance efficient tests.

### Prerequisites

IDE like Eclipse or IntelliJ and JDK 1.8 installed.

### Installing

Open Eclipse IDE

Import by cloning remote project from the repository : https://github.com/amruthakatteri/Metaweather.git

Right click Project -> Maven -> Update Project

Right click Project -> Run As -> Maven clean

Right click Project -> Run As -> Maven test

Test Execution reports can be found in Project->target->cucumber-reports

## Running the tests

Method 1:

Right click Project -> Run As -> Maven clean

Right click Project -> Run As -> Maven test

Test Execution reports can be found in Project->target->cucumber-reports

Method 2:

Right Click com.bbc.automation.runners.TestRunner.java -> Run As -> Junit Test

## Authors

* **Amrutha Katteri**


