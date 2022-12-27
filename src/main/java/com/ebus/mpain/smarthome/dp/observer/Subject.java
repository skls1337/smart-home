package com.ebus.mpain.smarthome.dp.observer;

import com.ebus.mpain.smarthome.model.HumiditySensor;

// Interfața pentru subiectul care notifică observatorii
public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
    void setMeasurements(HumiditySensor humiditySensor);
}