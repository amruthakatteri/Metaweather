package com.bbc.automation.stepdefinitions;

import static org.junit.Assert.assertEquals;
import com.bbc.automation.api.metaweather.location.LocationApi;
import com.bbc.automation.api.metaweather.location.LocationDayApi;
import com.bbc.automation.api.metaweather.location.LocationDayResponse;
import com.bbc.automation.api.metaweather.location.LocationResponse;
import com.bbc.automation.api.metaweather.location.LocationSearchApi;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class WeatherForLocationAndDateSteps {

	@When("I verify the weather forecast for {string} for Today is {string}")
	public void i_verify_the_weather_forecast_for_for_today_is(String cityName, String expectedWeatherStateName)
	{
		int Woeid= LocationSearchApi.GetWOEIDForLocation(cityName);
		String actualWeatherStateName=null;
		if (Woeid >= 0)
		{
			LocationDayResponse response = LocationDayApi.GetWeatherForecastWithDate(Woeid,0);
			if(response.consolidated_weather.length > 0)
			{
				actualWeatherStateName = response.consolidated_weather[0].weather_state_name;
				
			}
			assertEquals("Mismatch between expected weather state and actual weather state ",expectedWeatherStateName, actualWeatherStateName);
		}
		else 
			Assert.fail("Invalid city name : " + cityName);
	}

	@When("I verify the weather forecast for {string} for {int} days from Today is {string}")
	public void i_verify_the_weather_forecast_for_for_date_days_from_today_is(String cityName, int noOfDaysFromToday, String expectedWeatherStateName) 
	{
		int Woeid= LocationSearchApi.GetWOEIDForLocation(cityName);
		String actualWeatherStateName=null;
		if (Woeid >= 0)
		{
			LocationDayResponse response = LocationDayApi.GetWeatherForecastWithDate(Woeid,noOfDaysFromToday);
			if(response.consolidated_weather.length > 0)
			{
				actualWeatherStateName = response.consolidated_weather[0].weather_state_name;
				
			}
			assertEquals("Mismatch between expected weather state and actual weather state ",expectedWeatherStateName, actualWeatherStateName);
		}
		else 
			Assert.fail("Invalid city name : " + cityName);
	}

	@When("I verify the {int} days weather forecast including Today is returned for {string}")
	public void i_verify_the_days_weather_forecast_is_returned_for(int expectedNoOfDaysOfForecast, String cityName) 
	{
		int Woeid= LocationSearchApi.GetWOEIDForLocation(cityName);
		if (Woeid >= 0)
		{
			LocationResponse response = LocationApi.GetWeatherForecastForLocation(Woeid);
			int actualNoOfDaysOfForecast = response.consolidated_weather.length;
			assertEquals("Mismatch between expected number of days of wheather forecast and the actual result ",expectedNoOfDaysOfForecast, actualNoOfDaysOfForecast);
		}
		else 
			Assert.fail("Invalid city name : " + cityName);
	}

}
