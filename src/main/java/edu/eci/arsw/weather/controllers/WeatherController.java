package edu.eci.arsw.weather.controllers;


import edu.eci.arsw.weather.services.WeatherServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/weather")
public class WeatherController {

	@Autowired
	private WeatherServices weater;
	
	@RequestMapping(method = RequestMethod.GET,path = "{city}")
	public ResponseEntity<?> GetCinemasByName(@PathVariable String city ){
	    try {
	    	return new ResponseEntity<> (weater.getWeatherByCity(city),HttpStatus.ACCEPTED);
	    } catch (Exception ex) {
	        return new ResponseEntity<>("Error 404",HttpStatus.NOT_FOUND);
	    }
	}
}
