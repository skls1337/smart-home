package com.ebus.mpain.smarthome.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class HumiditySensor {
    private float temperature;
    private float humidity;
    private Date createdAt;
    private Date updatedAt;
}
