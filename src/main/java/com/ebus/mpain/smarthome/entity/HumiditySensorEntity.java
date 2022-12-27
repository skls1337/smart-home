package com.ebus.mpain.smarthome.entity;

import com.ebus.mpain.smarthome.model.HumiditySensor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "humidity_sensors")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HumiditySensorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "temperature")
    private float temperature;

    @Column(name = "humidity")
    private float humidity;

    @Column(name = "created_at", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @PrePersist
    void prePersist() {
        createdAt = new Date();
    }

    @PreUpdate
    void preUpdate() {
        updatedAt = new Date();
    }

    public HumiditySensor map() {
        return HumiditySensor.builder()
                .humidity(humidity)
                .temperature(temperature)
                .build();
    }

    public static HumiditySensorEntity create(HumiditySensor humiditySensor) {
        return HumiditySensorEntity.builder()
                .humidity(humiditySensor.getHumidity())
                .temperature(humiditySensor.getTemperature())
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();
    }
}
