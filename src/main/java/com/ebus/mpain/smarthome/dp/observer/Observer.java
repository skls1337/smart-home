package com.ebus.mpain.smarthome.dp.observer;

import com.ebus.mpain.smarthome.model.HumiditySensor;

// Interfața pentru observatori
public interface Observer {
    void update(HumiditySensor humiditySensor);
}