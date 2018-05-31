package com.menga.head_first_design_patterns.c2_1;

import java.util.Observable;

/**
 * Created by Marvel on 2018/5/30.
 */
public class WeatherData extends Observable {

    private Measurements measurements;

    public WeatherData() {
        super();
    }

    public void measurementsChanged() {
        setChanged();
        notifyObservers(measurements);
    }

    public void setMeasurements(Measurements measurements) {
        this.measurements = measurements;
        measurementsChanged();
    }

}
