package com.ebus.mpain.smarthome.dp.observer;

import com.ebus.mpain.smarthome.model.HumiditySensor;

public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
    void setMeasurements(HumiditySensor humiditySensor);
}