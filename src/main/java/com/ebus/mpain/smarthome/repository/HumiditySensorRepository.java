package com.ebus.mpain.smarthome.repository;

import com.ebus.mpain.smarthome.entity.HumiditySensorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HumiditySensorRepository extends JpaRepository<HumiditySensorEntity, Long> {
}
