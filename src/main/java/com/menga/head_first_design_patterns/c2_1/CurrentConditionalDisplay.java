package com.menga.head_first_design_patterns.c2_1;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Marvel on 2018/5/30.
 */
public class CurrentConditionalDisplay implements Observer, DisplayElement {

    private Measurements measurements;

    @Override
    public void display() {
        System.out.println("CurrentConditionalDisplay: 当前的温度为：" + measurements.getTemperature() + "，湿度为：" + measurements.getHumidity());
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            this.measurements = (Measurements) arg;
            display();
        }
    }
}
