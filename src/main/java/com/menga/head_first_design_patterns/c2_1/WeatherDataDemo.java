package com.menga.head_first_design_patterns.c2_1;

/**
 * Created by Marvel on 2018/5/30.
 */
public class WeatherDataDemo {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionalDisplay currentConditionalDisplay = new CurrentConditionalDisplay();
        ForecastDisplay forecastDisplay = new ForecastDisplay();

        weatherData.addObserver(currentConditionalDisplay);
        weatherData.addObserver(forecastDisplay);

        weatherData.setMeasurements(new Measurements(30, 60, 40));
        weatherData.setMeasurements(new Measurements(35, 67, 60));
        weatherData.setMeasurements(new Measurements(37, 69, 120));
        weatherData.setMeasurements(new Measurements(32, 52, 30));
    }
}
