package com.ebus.mpain.smarthome.dp.observer;

import com.ebus.mpain.smarthome.model.HumiditySensor;

public interface Observer {
    void update(HumiditySensor humiditySensor);
}