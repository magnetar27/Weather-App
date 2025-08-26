package com.weatherapp.controller;

import com.weatherapp.model.WeatherResponse;
import com.weatherapp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/api/weather")
    public ResponseEntity<?> getWeather(@RequestParam("city") String city) {
        try {
            WeatherResponse weatherData = weatherService.getWeatherData(city);
            return ResponseEntity.ok(weatherData);
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error fetching weather data: " + e.getMessage());
        }
    }
}
