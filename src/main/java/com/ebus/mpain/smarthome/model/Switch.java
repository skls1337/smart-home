package com.ebus.mpain.smarthome.model;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
@RequiredArgsConstructor
@Getter
public class Switch implements AbstractDevice {
    private static final Logger LOG = LoggerFactory.getLogger(Switch.class);

    @Override
    public void switchDevice() {
        LOG.info("Switch enabled");
    }
}
