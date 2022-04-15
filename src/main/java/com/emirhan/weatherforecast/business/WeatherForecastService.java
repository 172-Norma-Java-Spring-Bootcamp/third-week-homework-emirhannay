package com.emirhan.weatherforecast.business;

import com.emirhan.weatherforecast.core.Response;

public interface WeatherForecastService  {
    Response getWeatherForecast(String cityName, int day);
}
