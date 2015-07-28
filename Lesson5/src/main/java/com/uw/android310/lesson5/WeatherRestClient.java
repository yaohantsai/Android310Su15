package com.uw.android310.lesson5;

/**
 * Created by JT on 2015/7/20.
 */
public class WeatherRestClient {
    private  static  WeatherAPI REST_CLIENT;
    private static String ROOT="http://api.openweahter.org/data/2.5";
    static {
        setupRestClient();
    }
    private WeatherRestClient(){}
    public static WeatherAPI get(){
        return REST_CLIENT;
    }

}
