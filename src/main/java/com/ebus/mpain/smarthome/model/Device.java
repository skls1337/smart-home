package com.ebus.mpain.smarthome.model;

import lombok.ToString;

import java.util.HashMap;
import java.util.Map;


@ToString
public class Device {
    private final String name;
    private final String type;
    private final boolean isSmart;
    private final Map<String, String> properties;


    private Device(DeviceBuilder builder) {
        this.name = builder.name;
        this.type = builder.type;
        this.isSmart = builder.isSmart;
        this.properties = builder.properties;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean isSmart() {
        return isSmart;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public static class DeviceBuilder {
        private final String name;
        private final String type;
        private boolean isSmart = false;
        private Map<String, String> properties = new HashMap<>();

        public DeviceBuilder(String name, String type) {
            this.name = name;
            this.type = type;
        }

        public DeviceBuilder setSmart(boolean isSmart) {
            this.isSmart = isSmart;
            return this;
        }

        public DeviceBuilder setProperty(String key, String value) {
            this.properties.put(key, value);
            return this;
        }

        public Device build() {
            return new Device(this);
        }
    }
}
