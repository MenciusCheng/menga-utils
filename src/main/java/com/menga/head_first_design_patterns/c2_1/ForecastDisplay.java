package com.menga.head_first_design_patterns.c2_1;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Marvel on 2018/5/30.
 */
public class ForecastDisplay implements Observer, DisplayElement {

    private Measurements measurements;

    @Override
    public void display() {
        System.out.println("ForecastDisplay: 当前的气压为：" + measurements.getPressure());
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            this.measurements = (Measurements) arg;
            display();
            if (measurements.getPressure() > 100) {
                o.deleteObserver(this);
                System.out.println("ForecastDisplay: 压力太大，我先去休息了");
            }
        }

    }
}
