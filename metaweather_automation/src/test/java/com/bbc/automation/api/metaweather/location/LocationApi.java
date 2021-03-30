package com.bbc.automation.api.metaweather.location;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import com.bbc.automation.ConfigProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LocationApi {

	private static Response response;

	public static LocationResponse GetWeatherForecastForLocation(int Woeid)
	{
		String CONSTANT_SLASH="/";
		// Build REST request for getting 6 days weather forecast for the given WOEID
		String resourcePath = Woeid+ CONSTANT_SLASH;
		String locationEndpoint = ConfigProperties.getInstance().getValue("metaweather_endpoint_url")+ resourcePath;

		//Fetch response from Location API
		response= given().when().get(locationEndpoint);
		ObjectMapper mapper = new ObjectMapper();

		try 
		{
			//Deserialize json String to Object
			LocationResponse locationResponse = mapper.readValue(response.getBody().asString(), LocationResponse.class);
			return locationResponse;
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
}



