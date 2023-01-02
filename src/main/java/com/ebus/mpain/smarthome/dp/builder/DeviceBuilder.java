package com.ebus.mpain.smarthome.dp.builder;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DeviceBuilder {
    String name();
    String type();
    boolean isSmart() default false;
    String[] properties() default {};
}