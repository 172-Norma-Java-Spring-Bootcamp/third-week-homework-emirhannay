package com.emirhan.weatherforecast.model;

import com.emirhan.weatherforecast.core.Data;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//Since the data I got from api is not data that can be returned, I created this model and will return it to the user this model.
public class WeatherForecast implements Data {
        private float humidity;
        private float maxTemp;
        private float minTemp;
        private String condition;
        private Date date;
}
