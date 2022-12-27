package com.ebus.mpain.smarthome.web.controller;

import com.ebus.mpain.smarthome.dp.observer.Observer;
import com.ebus.mpain.smarthome.dp.observer.Subject;
import com.ebus.mpain.smarthome.model.HumiditySensor;
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
    Subject sensorService;

    @Autowired
    Observer report;

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
}
