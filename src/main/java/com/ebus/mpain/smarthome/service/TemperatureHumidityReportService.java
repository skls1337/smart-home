package com.ebus.mpain.smarthome.service;

import com.ebus.mpain.smarthome.dp.observer.Observer;
import com.ebus.mpain.smarthome.entity.HumiditySensorEntity;
import com.ebus.mpain.smarthome.model.HumiditySensor;
import com.ebus.mpain.smarthome.repository.HumiditySensorRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
@RequiredArgsConstructor
public class TemperatureHumidityReportService implements Observer {
    @Autowired
    private final HumiditySensorRepository humiditySensorRepository;
    private static final Logger LOG = LoggerFactory.getLogger(HumiditySensorRepository.class);

    @Override
    public void update(HumiditySensor humiditySensor) {
        LOG.info("Temperature: " + humiditySensor.getTemperature() + " Humidity: " + humiditySensor.getHumidity());
        humiditySensorRepository.save(HumiditySensorEntity.create(humiditySensor));
    }
}
