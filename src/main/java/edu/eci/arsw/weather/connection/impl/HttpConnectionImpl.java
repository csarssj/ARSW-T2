package edu.eci.arsw.weather.connection.impl;

import edu.eci.arsw.weather.connection.HttpConnection;
import edu.eci.arsw.weather.connection.WeatherException;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class HttpConnectionImpl implements HttpConnection {

    /**
     * Se realiza la conexion y peticion de datos a traves del protocolo HTTP
     *
     * @param city
     * @return
     * @throws WeatherException
     * @throws IOException
     */
	
	@Override
	public String getWeatherByCity(String city)  throws WeatherException, IOException {
		String USER_AGENT = "Mozilla/5.0";
    	String GET_URL = "http://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=e0a8fd902325e9485958375ae4c8e13a";
    	
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        
        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
            return response.toString();
        } else {
           // System.out.println("GET request not worked");
        	return null;
        }
        //System.out.println("GET DONE");
	}
	
}
