package com.ebus.mpain.smarthome.service;

import com.ebus.mpain.smarthome.dp.command.DoorLock;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Data
@Service
@RequiredArgsConstructor
public class DoorLockService implements DoorLock {
    private static final Logger LOG = LoggerFactory.getLogger(DoorLockService.class);
    @Override
    public void lockDoor() {
        LOG.info("Door is locked");
    }

    @Override
    public void unlockDoor() {
        LOG.info("Door is unlocked");
    }
}
