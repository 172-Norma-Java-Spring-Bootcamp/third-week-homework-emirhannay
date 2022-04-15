package com.emirhan.weatherforecast.business;

import com.emirhan.weatherforecast.model.WeatherApiData;


public interface WeatherForecastApiAdaptor {
    WeatherApiData getWeatherForecast (String cityName,int day);
}
