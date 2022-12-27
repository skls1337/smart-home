package com.ebus.mpain.smarthome.service;

import com.ebus.mpain.smarthome.dp.observer.Observer;
import com.ebus.mpain.smarthome.dp.observer.Subject;
import com.ebus.mpain.smarthome.model.HumiditySensor;
import com.ebus.mpain.smarthome.repository.HumiditySensorRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class TemperatureHumiditySensorService implements Subject {
    private static final Logger LOG = LoggerFactory.getLogger(TemperatureHumiditySensorService.class);
    private List<Observer> observers = new ArrayList<>();
    private HumiditySensor humiditySensor;

    @Autowired
    private final HumiditySensorRepository humiditySensorRepository;

    // Metode pentru înregistrarea și eliminarea observatorilor
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    // Metoda pentru notificarea observatorilor când se produc schimbări în date
    @Override
    public void notifyObservers() {
        if(observers.isEmpty()) {
            LOG.info("No observered registered");
            return;
        }
        for (Observer observer : observers) {
            observer.update(humiditySensor);
        }
    }

    // Metoda care actualizează datele colectate de senzor
    @Override
    public void setMeasurements(HumiditySensor humiditySensor) {
        this.humiditySensor = humiditySensor;
        notifyObservers();
    }
}
