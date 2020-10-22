/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.weather.services;


import edu.eci.arsw.weather.connection.HttpConnection;
import edu.eci.arsw.weather.connection.WeatherException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeatherServices {

	@Autowired
	HttpConnection http;

	public String getWeatherByCity(String city) throws WeatherException, IOException {
		String data = http.getWeatherByCity(city);
		System.out.println(data);
		return  data;
	}
}

