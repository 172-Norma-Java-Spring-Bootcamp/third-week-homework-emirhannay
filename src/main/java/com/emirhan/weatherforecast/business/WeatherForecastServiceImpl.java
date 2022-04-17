package com.emirhan.weatherforecast.business;

import com.emirhan.weatherforecast.core.Data;
import com.emirhan.weatherforecast.core.Response;
import com.emirhan.weatherforecast.model.WeatherApiData;
import com.emirhan.weatherforecast.model.WeatherForecast;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
//Here I take the data from the API and transform it into my own model
public class WeatherForecastServiceImpl implements WeatherForecastService {


    private final WeatherForecastApiAdaptor weatherForecastApiAdaptor;

    public WeatherForecastServiceImpl(WeatherForecastApiAdaptor weatherForecastApiAdaptor) {
        this.weatherForecastApiAdaptor = weatherForecastApiAdaptor;
    }


    public Response getWeatherForecast(String cityName, int day) {

        WeatherApiData weatherApiData = weatherForecastApiAdaptor.getWeatherForecast(cityName, day);
        Optional<List<WeatherApiData.ForecastDay>> x = weatherApiData.getForecastDay();
        ArrayList<Data> weatherForecastList = new ArrayList<Data>();
        for(int i = 0; i < x.get().size(); i ++ ){
            WeatherForecast temp = new WeatherForecast();
            temp.setCondition(x.get().get(i).getDay().getCondition().getText());
            temp.setDate(x.get().get(i).getDate());
            temp.setMinTemp(x.get().get(i).getDay().getMintemp());
            temp.setMaxTemp(x.get().get(i).getDay().getMaxtemp());
            temp.setHumidity(x.get().get(i).getDay().getHumidity());
            weatherForecastList.add(temp);
        }

        return new Response("Success",weatherForecastList);
    }



}
