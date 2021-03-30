package com.bbc.automation.api.metaweather.location;

import io.restassured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.bbc.automation.ConfigProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author amrutha.katteri
 *
 */
public class LocationSearchApi 
{
	private static Response response;
	private static RequestSpecification request;
	
	/* Returns WOEID(Integer>1) for the given city
	 * Returns -1 if Multiple WOEID is found for the provided city name eg: Manchester
	 * Returns -2 if the entered city name is invalid eg: XYZ
	 * Returns -3 if the entered city name is found as a substring among many cities and 
	 * 				not able to found the exact match with any of the cities. eg : don 
	 */
	public static int GetWOEIDForLocation(String cityName ) 
	{
		// Build REST request for getting WOEID for the given city name	
		RestAssured.baseURI =ConfigProperties.getInstance().getValue("metaweather_endpoint_url");
		String resourcePath = ConfigProperties.getInstance().getValue("locationSearch_resourcePath");
		request = RestAssured.given();
		
		//Fetch response from Location Search API
		response = request.queryParam("query",cityName).get(resourcePath);
		ObjectMapper mapper = new ObjectMapper();
		try 
		{
			//Deserialize json String to Object
			LocationSearchResponse[] asArray = mapper.readValue(response.getBody().asString(), LocationSearchResponse[].class);
			int LengthOfasArray = asArray.length;
			int matchingCityCount =0;
			int count =0;
			int position=0;
			while(count<LengthOfasArray)
			{
				if(asArray[count].title.equalsIgnoreCase(cityName))
				{
					position=count;
					matchingCityCount= matchingCityCount+1;
				}
				count++;	
			}
			if( matchingCityCount==1)
			{
				return asArray[position].woeid;
			}
			else if ( matchingCityCount>1)
				// Multiple WOEID is found for the provided city name eg: Manchester
				return -1;
			else if(LengthOfasArray==0)
			{
				// The entered city name is invalid eg: XYZ
				return -2;
			}
			else 
			{
				/* The entered city name is found as a substring among many cities and 
				not able to found the exact match with any of the cities.eg : don */
				return -3;
			}		    		

		} catch (JsonMappingException e) {
			e.printStackTrace();

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return -4;
	}
}

