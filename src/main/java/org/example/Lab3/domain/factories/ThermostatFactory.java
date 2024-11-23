package org.example.Lab3.domain.factories;

import org.example.Lab3.domain.clases.Device;
import org.example.Lab3.domain.clases.Thermostat;

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