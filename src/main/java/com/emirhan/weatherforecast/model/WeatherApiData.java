package com.emirhan.weatherforecast.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
//Model created to get required data from api
public class WeatherApiData  {

    @JsonProperty("forecast")
    private final Forecast forecast;

    @JsonCreator
    public WeatherApiData(@JsonProperty(value = "forecast", required = true) Forecast forecast) {
        this.forecast = forecast;
    }



    public Optional<List<ForecastDay>> getForecastDay(){
        return Optional.of(forecast.forecastDays);
    }

    public static class Forecast {
        @JsonProperty("forecastday")
        private final List<ForecastDay> forecastDays;

        @JsonCreator
        public Forecast(@JsonProperty(value = "forecastday", required = true) List<ForecastDay> forecastDays) {
            this.forecastDays = forecastDays;
        }
    }


    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class ForecastDay {
        @JsonProperty("date")
        private final Date date;
        @JsonProperty("day")
        private final Day day;


        @JsonCreator
        public ForecastDay(@JsonProperty(value = "date", required = true) Date date, @JsonProperty(value = "day", required = true) Day day) {
            this.date = date;
            this.day = day;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class Day {
        @JsonProperty("maxtemp_c")
        private final float maxtemp;
        @JsonProperty("mintemp_c")
        private final float mintemp;
        @JsonProperty("avghumidity")
        private final float humidity;
        @JsonProperty("condition")
        private final Condition condition;

        @JsonCreator
        public Day(@JsonProperty(value = "maxtemp_c", required = true) float maxtemp,
                   @JsonProperty(value = "mintemp_c", required = true) float mintemp,
                   @JsonProperty(value = "avghumidity", required = true) float humidity,
                   @JsonProperty(value = "condition", required = true) Condition condition) {
            this.maxtemp = maxtemp;
            this.mintemp = mintemp;
            this.humidity = humidity;
            this.condition = condition;
        }


    }
    @Getter
    public static class Condition {
        @JsonProperty("text")
        private final String text;

        public Condition(@JsonProperty(value ="text", required = true) String text) {
            this.text = text;
        }
    }
}
