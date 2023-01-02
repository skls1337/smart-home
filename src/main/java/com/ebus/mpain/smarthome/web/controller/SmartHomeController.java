package com.ebus.mpain.smarthome.web.controller;

import com.ebus.mpain.smarthome.dp.command.Command;
import com.ebus.mpain.smarthome.dp.factory.AbstractDeviceFactory;
import com.ebus.mpain.smarthome.dp.observer.Observer;
import com.ebus.mpain.smarthome.dp.observer.Subject;
import com.ebus.mpain.smarthome.model.AbstractDevice;
import com.ebus.mpain.smarthome.model.HumiditySensor;
import com.ebus.mpain.smarthome.model.LightBulb;
import com.ebus.mpain.smarthome.service.FactoryProducerService;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Data
@RequestMapping("api/v1")
public class SmartHomeController {
    private static final Logger LOG = LoggerFactory.getLogger(SmartHomeController.class);
    @Autowired
    private Command command;

    @Autowired
    Subject sensorService;

    @Autowired
    Observer report;

    AbstractDeviceFactory abstractDeviceFactory;

    @PostMapping("sensor/register")
    public void registerSensor() {
        sensorService.registerObserver(report);
        LOG.info("Sensor registered");
    }

    @PostMapping("sensor")
    public void setHumiditySensor(@RequestBody HumiditySensor humiditySensor) {
        sensorService.setMeasurements(humiditySensor);
    }

    @GetMapping("/observer/notify")
    public void notifyObservers() {
        LOG.info("Notifying observers...");
        sensorService.notifyObservers();
    }

    @PostMapping("/lock")
    public void lockDoor(@RequestBody boolean locked) {
        command.execute(locked);
    }

    @PostMapping("/factory/device")
    public void createDevice(@RequestParam String type) {
        abstractDeviceFactory = FactoryProducerService.deviceFactory(type);
        if (type.equalsIgnoreCase("smart")) {
            AbstractDevice bulb = abstractDeviceFactory.getDevice("LightBulb");
            bulb.switchDevice();
            AbstractDevice thermostat = abstractDeviceFactory.getDevice("Thermostat");
            thermostat.switchDevice();
        } else {
            AbstractDevice router = abstractDeviceFactory.getDevice("Router");
            router.switchDevice();
            AbstractDevice _switch = abstractDeviceFactory.getDevice("Switch");
            _switch.switchDevice();
        }

    }

}
