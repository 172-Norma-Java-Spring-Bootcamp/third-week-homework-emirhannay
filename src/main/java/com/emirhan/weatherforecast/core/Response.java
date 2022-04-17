package com.emirhan.weatherforecast.core;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
//My custom response class
public class Response {
    private String message;
    private ArrayList<Data> data;

    public Response(String message, ArrayList<Data> data) {
        this.message = message;
        this.data = data;
    }





}
