package com.bbc.automation.runners;
	
//Runner class

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;	
	
@RunWith(Cucumber.class)				
@CucumberOptions(
		features = "Features",
		glue = {"com.bbc.automation.stepdefinitions"},
		tags = "@RegressionTest",
		plugin = { "pretty", "html:target/cucumber-reports" },
		 monochrome = true)					
public class TestRunner 				
{		

}

