package com.ebus.mpain.smarthome.dp.factory;

import com.ebus.mpain.smarthome.model.AbstractDevice;

public abstract class AbstractDeviceFactory {
    public abstract AbstractDevice getDevice(String deviceType);
}
