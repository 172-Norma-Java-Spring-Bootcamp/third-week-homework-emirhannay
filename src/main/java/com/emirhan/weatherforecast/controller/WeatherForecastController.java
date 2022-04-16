package com.emirhan.weatherforecast.controller;


import com.emirhan.weatherforecast.business.WeatherForecastService;
import com.emirhan.weatherforecast.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/weather")
@Validated
public class WeatherForecastController {

    private WeatherForecastService weatherForecastService;

    @Autowired
    public WeatherForecastController(WeatherForecastService weatherForecastService) {
        this.weatherForecastService = weatherForecastService;
    }

    @GetMapping("/getWeatherForecast/{cityName}/{day}")
    public ResponseEntity<Response> getWeatherForecastData(@PathVariable("cityName") String cityName,
                                                                  @Min(value = 1, message = "Gün bilgisi 1'den az olamaz")
                                                                  @Max(value = 3, message = "Gün bilgisi 3'ten büyük olamaz")
                                                                  @PathVariable("day") int day){

        return new ResponseEntity<Response>(weatherForecastService.getWeatherForecast(cityName,day),HttpStatus.OK);
    }






}
