package edu.eci.arsw.weather.cache;

import edu.eci.arsw.weather.connection.HttpConnection;
import edu.eci.arsw.weather.connection.WeatherException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;


@Service
public class WeatherCache {

    @Autowired
    HttpConnection http;

    private ConcurrentHashMap<String, String> cities = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, LocalDateTime> time = new ConcurrentHashMap<>();


    /**
     * Agrega una ciudad y sus datos a una estructura de datos concurrente, además del tiempo en el que fue agregado
     *
     * @param name
     * @param weather
     */
    public void addCities(String name ,String weather){
            cities.put(name,weather);
            time.put(name, LocalDateTime.now());
    }

    /**
     *
     * @param name nombre de la ciudad a consular
     * @return las estadisticas del clima de la ciudad correspondiente, si es dentro un intervalo de 5 minutos
     * se conserva en el cache de la app
     * @throws IOException
     * @throws WeatherException
     */
    public String getCity(String name) throws IOException, WeatherException {
        //System.out.println("Entro en cache1");
        if(cities.containsKey(name)) {
            //System.out.println("Entro en cache2");
            LocalDateTime weatherTime = time.get(name);
            if(LocalDateTime.now().isAfter(weatherTime.plusMinutes(5))) {
              //  System.out.println("5 minutos");
                String weather = http.getWeatherByCity(name);
                cities.replace(name, weather);
                time.replace(name, LocalDateTime.now());
                return weather;
            }
            //System.out.println("te caché xd");
            return cities.get(name);
        }else{
            //System.out.println("Entra por aca");
            String weather = http.getWeatherByCity(name);
            cities.put(name,weather);
            time.put(name, LocalDateTime.now());
            return weather;
        }
    }
}
