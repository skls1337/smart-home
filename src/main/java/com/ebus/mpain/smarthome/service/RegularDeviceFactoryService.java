package com.ebus.mpain.smarthome.service;

import com.ebus.mpain.smarthome.dp.factory.AbstractDeviceFactory;
import com.ebus.mpain.smarthome.model.*;
import org.springframework.stereotype.Service;

@Service
public class RegularDeviceFactoryService extends AbstractDeviceFactory {
    @Override
    public AbstractDevice getDevice(String deviceType) {
        switch (deviceType) {
            case "Router":
                return new Router();
            case "Switch":
                return new Switch();
            default:
                throw new IllegalArgumentException("Invalid device type");
        }
    }
}