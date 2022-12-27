package com.ebus.mpain.smarthome.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix="spring.datasource", ignoreUnknownFields = false)
public class DataSourceConfig {
    String url;
    String username;
    String password;
}
