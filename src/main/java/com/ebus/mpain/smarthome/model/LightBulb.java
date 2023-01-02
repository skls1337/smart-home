package com.ebus.mpain.smarthome.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
@Getter
@AllArgsConstructor
public class LightBulb implements AbstractDevice {
    private static final Logger LOG = LoggerFactory.getLogger(LightBulb.class);
    @Override
    public void switchDevice() {
        LOG.info("Light bulb switched");
    }
}
