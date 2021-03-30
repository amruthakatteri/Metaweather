package com.bbc.automation.api.metaweather.location;
/**
 * @author amrutha.katteri
 *
 */
//Holds the data model for Location Day API Response

public class LocationDayResponse {

	public ConsolidatedWeather[] consolidated_weather;

	public static class ConsolidatedWeather {
		public float id;
		public String weather_state_name;
		public String weather_state_abbr;
		public String wind_direction_compass;
		public String created;
		public String applicable_date;
		public float min_temp;
		public float max_temp;
		public float the_temp;
		public float wind_speed;
		public float wind_direction;
		public float air_pressure;
		public float humidity;
		public float visibility;
		public float predictability;	
	}
}
