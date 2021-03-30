package com.bbc.automation.api.metaweather.location;

import static io.restassured.RestAssured.given;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

public class LocationDayApi {

	private static Response response;

	public static LocationDayResponse GetWeatherForecastWithDate(int Woeid, int noOfDaysFromToday)
	{
		// Build REST request for getting weather_state_name for the given woeid
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, noOfDaysFromToday); 
		String formattedDate = sdf.format(cal.getTime());
		String resourcePath = Woeid+ "/" + formattedDate+ "/" ;
		String EndpointUrl = LocationSearchApi.ENDPOINT_GET_METAWEATHER+ resourcePath;
		response = given().when().get(EndpointUrl);
		ObjectMapper mapper = new ObjectMapper();
		try {
			LocationDayResponse locationDayResponse = new LocationDayResponse();
			locationDayResponse.consolidated_weather = mapper.readValue(response.getBody().asString(), LocationDayResponse.ConsolidatedWeather[].class);
			return locationDayResponse;			
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
}


