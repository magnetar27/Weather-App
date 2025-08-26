package com.weatherapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {

    @JsonProperty("name")
    private String cityName;

    @JsonProperty("main")
    private Main main;

    @JsonProperty("weather")
    private Weather[] weather;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Main {
        private double temp;
        private int humidity;

        public double getTemp() { return temp; }
        public void setTemp(double temp) { this.temp = temp; }
        public int getHumidity() { return humidity; }
        public void setHumidity(int humidity) { this.humidity = humidity; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Weather {
        private String description;
        private String icon;

        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
        public String getIcon() { return icon; }
        public void setIcon(String icon) { this.icon = icon; }
    }

    public String getCityName() { return cityName; }
    public void setCityName(String cityName) { this.cityName = cityName; }

    public Main getMain() { return main; }
    public void setMain(Main main) { this.main = main; }

    public Weather[] getWeather() { return weather; }
    public void setWeather(Weather[] weather) { this.weather = weather; }
}
