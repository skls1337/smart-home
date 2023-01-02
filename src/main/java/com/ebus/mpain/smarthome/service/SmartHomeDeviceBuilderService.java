package com.ebus.mpain.smarthome.service;

import com.ebus.mpain.smarthome.dp.builder.DeviceBuilder;
import com.ebus.mpain.smarthome.model.Device;
import org.springframework.stereotype.Service;

@Service
public class SmartHomeDeviceBuilderService {
    @DeviceBuilder(name = "Thermostat", type = "Temperature Control", isSmart = true)
    public Device createDevice(String[] properties) {
        Device.DeviceBuilder builder = new Device.DeviceBuilder("Thermostat", "Temperature Control");
        builder.setSmart(true);
        for (int i = 0; i < properties.length; i += 2) {
            String key = properties[i];
            String value = properties[i + 1];
            builder.setProperty(key, value);
        }
        return builder.build();
    }
}
