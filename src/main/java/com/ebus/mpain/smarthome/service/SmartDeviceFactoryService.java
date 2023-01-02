package com.ebus.mpain.smarthome.service;

import com.ebus.mpain.smarthome.dp.factory.AbstractDeviceFactory;
import com.ebus.mpain.smarthome.model.AbstractDevice;
import com.ebus.mpain.smarthome.model.LightBulb;
import com.ebus.mpain.smarthome.model.Thermostat;
import org.springframework.stereotype.Service;

@Service
public class SmartDeviceFactoryService extends AbstractDeviceFactory {
    @Override
    public AbstractDevice getDevice(String deviceType) {
        switch (deviceType) {
            case "LightBulb":
                return new LightBulb();
            case "Thermostat":
                return new Thermostat();
            default:
                throw new IllegalArgumentException("Invalid device type");
        }
    }
}
