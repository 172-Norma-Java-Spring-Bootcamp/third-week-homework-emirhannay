package com.emirhan.weatherforecast.controller;


import com.emirhan.weatherforecast.business.WeatherForecastService;
import com.emirhan.weatherforecast.core.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/api")
@Validated
public class WeatherForecastController {

    private final WeatherForecastService weatherForecastService;

    public WeatherForecastController(WeatherForecastService weatherForecastService) {
        this.weatherForecastService = weatherForecastService;
    }

    @GetMapping("/weathers/search")
    public ResponseEntity<Response> getWeatherForecastData(@RequestParam("cityName") String cityName,
                                                                  @Min(value = 1, message = "Gün bilgisi 1'den az olamaz")
                                                                  @Max(value = 3, message = "Gün bilgisi 3'ten büyük olamaz")
                                                                  @RequestParam("day") int day){

        return new ResponseEntity<Response>(weatherForecastService.getWeatherForecast(cityName,day),HttpStatus.OK);
    }






}
