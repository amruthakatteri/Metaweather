package com.bbc.automation.runners;
	

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;	
	

@RunWith(Cucumber.class)				
@CucumberOptions(
		features = "Features",glue = {"com.bbc.automation.stepdefinitions"},tags = "@SmokeTest",
		plugin = { "pretty", "html:target/cucumber-reports" },
		 monochrome = true)					
public class TestRunner 				
{		

}

