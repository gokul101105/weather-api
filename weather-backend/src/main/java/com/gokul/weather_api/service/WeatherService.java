package com.gokul.weather_api.service;

import com.gokul.weather_api.exception.CityNotFoundException;
import com.gokul.weather_api.model.GeocodingResponse;
import com.gokul.weather_api.model.WeatherDto;
import com.gokul.weather_api.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class WeatherService {

    @Value("${weather.api.url}")
    private String weatherApiUrl;

    @Value("${geocoding.api.url}")
    private String geocodingApiUrl;

    private final RestClient restClient;

    public WeatherService(RestClient restClient) {
        this.restClient = restClient;
    }

    public WeatherDto getWeather(String city) {

        String geoUrl = geocodingApiUrl + "?name=" + city + "&count=1";

        GeocodingResponse geoResponse = restClient.get()
                .uri(geoUrl)
                .retrieve()
                .body(GeocodingResponse.class);

        if (geoResponse == null ||
                geoResponse.getResults() == null ||
                geoResponse.getResults().isEmpty()) {

            throw new CityNotFoundException("City not found: " + city);
        }

        double latitude = geoResponse.getResults().get(0).getLatitude();
        double longitude = geoResponse.getResults().get(0).getLongitude();

        String weatherUrl = weatherApiUrl
                + "?latitude=" + latitude
                + "&longitude=" + longitude
                + "&current=temperature_2m";

        WeatherResponse weatherResponse = restClient.get()
                .uri(weatherUrl)
                .retrieve()
                .body(WeatherResponse.class);

        WeatherDto dto = new WeatherDto();

        dto.setTemperature(
                weatherResponse.getCurrent().getTemperature_2m()
        );

        return dto;
    }
}