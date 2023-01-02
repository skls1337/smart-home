package com.ebus.mpain.smarthome.service;

import com.ebus.mpain.smarthome.dp.factory.AbstractDeviceFactory;
import org.springframework.stereotype.Service;

@Service
public class FactoryProducerService {
    public static AbstractDeviceFactory deviceFactory(String type) {
        switch (type) {
            case "Smart":
                return new SmartDeviceFactoryService();
            case "Regular":
                return new RegularDeviceFactoryService();
            default:
                throw new IllegalArgumentException("Invalid factory type");
        }
    }

}
