package org.example.Lab2.domain.factories;

import org.example.Lab3.domain.clases.Thermostat;
import org.example.Lab2.domain.clases.Device;

public class ThermostatFactory implements DeviceFactory {
    @Override
    public Device createDevice() {
        return new Thermostat.Builder()
                .name("Living Room Thermostat")
                .status(true)
                .temperature(22)
                .build();
    }
}