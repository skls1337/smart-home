package com.ebus.mpain.smarthome.service;

import com.ebus.mpain.smarthome.dp.command.Command;
import com.ebus.mpain.smarthome.dp.command.DoorLock;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
@RequiredArgsConstructor
public class DoorLockCommandService implements Command {

    @Autowired
    private DoorLock doorLock;

    @Override
    public void execute(boolean lock) {
        if (lock) {
            doorLock.lockDoor();
        } else {
            doorLock.unlockDoor();
        }
    }

}