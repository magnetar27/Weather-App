package com.weatherapp.service;


import com.weatherapp.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    private final String WEATHER_API_URL =
            "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric";

    public WeatherResponse getWeatherData(String city) {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format(WEATHER_API_URL, city, apiKey);
        return restTemplate.getForObject(url, WeatherResponse.class);
    }
}
