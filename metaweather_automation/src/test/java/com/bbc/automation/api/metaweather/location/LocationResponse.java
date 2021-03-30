package com.bbc.automation.api.metaweather.location;
/**
 * @author amrutha.katteri
 *
 */
public class LocationResponse {
	
	 public ConsolidatedWeather[] consolidated_weather;
	 public String time;
	 public String sun_rise;
	 public String sun_set;
	 public String timezone_name;
	 public Parent parent;
	 public Sources[] sources;
	 public String title;
	 public String location_type;
	 public float woeid;
	 public String latt_long;
	 public String timezone;

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
	
	public static class Sources{
		public String title;
		public String slug;
		public String url;
		public float crawl_rate;
	}
	
	public static class Parent{
		public String title;
		public String location_type;
		public float woeid;
		public String latt_long;
	}
	}
	

	


