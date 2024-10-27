package org.example.Lab2.factory;

import org.example.Lab2.device.Device;
import org.example.Lab2.device.Light;

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