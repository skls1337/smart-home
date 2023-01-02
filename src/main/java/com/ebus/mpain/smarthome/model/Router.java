package com.ebus.mpain.smarthome.model;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
@RequiredArgsConstructor
@Getter
public class Router implements AbstractDevice {
    private static final Logger LOG = LoggerFactory.getLogger(Router.class);

    @Override
    public void switchDevice() {
        LOG.info("Router is working");
    }
}
