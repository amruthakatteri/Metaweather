package com.bbc.automation.api.metaweather.location;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LocationApi {

	private static Response response;

	public static LocationResponse GetWeatherForecastForLocation(int Woeid)
	{
		// Build REST request for getting 6 days weather forecast for the given woeid
		String resourcePath = Woeid+ "/";
		String locationEndpoint = LocationSearchApi.ENDPOINT_GET_METAWEATHER+ resourcePath;
		response= given().when().get(locationEndpoint);
		ObjectMapper mapper = new ObjectMapper();
		try 
		{
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



