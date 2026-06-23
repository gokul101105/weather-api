package com.gokul.weather_api.controller;

import com.gokul.weather_api.model.WeatherDto;
import com.gokul.weather_api.model.WeatherResponse;
import com.gokul.weather_api.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class WeatherController {

    private final WeatherService weatherService;

     public WeatherController(WeatherService weatherService){
         this.weatherService = weatherService;
     }

    @GetMapping("/weather")
    public WeatherDto getWeather(@RequestParam String city){
        return weatherService.getWeather(city);
    }
}
