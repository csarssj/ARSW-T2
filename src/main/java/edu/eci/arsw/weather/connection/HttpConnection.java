package edu.eci.arsw.weather.connection;

import java.io.IOException;

public interface HttpConnection {
	 String getWeatherByCity(String city)  throws WeatherException, IOException ;
}
