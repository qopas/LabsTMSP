package org.example.Lab3.domain.factories;

import org.example.Lab3.domain.clases.Device;
import org.example.Lab3.domain.clases.Light;

/**
 * LightFactory is a concrete factory that creates Light devices.
 */

public class LightFactory implements DeviceFactory {
    @Override
    public Device createDevice() {
        return new Light.Builder()
                .name("Living Room Light")
                .status(true)
                .brightness(70)
                .build();
    }
}