package com.emirhan.weatherforecast.business;

import com.emirhan.weatherforecast.model.WeatherApiData;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
//External API system integration
//It takes the required data I want from the api and returns
public class WeatherForecastApiAdaptorImpl implements WeatherForecastApiAdaptor {

    private final RestTemplate restTemplate;

    public WeatherForecastApiAdaptorImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public WeatherApiData getWeatherForecast(String cityName, int day) {
        ResponseEntity<WeatherApiData> responseEntity =
                restTemplate.
                        getForEntity("http://api.weatherapi.com" +
                                        "/v1/forecast.json?" +
                                        "q=" +cityName+"&key=f3fa95e96b0b404e825193304221104&days="+day+"",
                                WeatherApiData.class);

        return responseEntity.getBody();

    }
}

