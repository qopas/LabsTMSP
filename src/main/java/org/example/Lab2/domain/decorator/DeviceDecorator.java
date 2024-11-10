package org.example.Lab2.domain.decorator;

import org.example.Lab2.domain.clases.Device;

public abstract class DeviceDecorator extends Device {
    protected Device decoratedDevice;

    public DeviceDecorator(Device device) {
        this.decoratedDevice = device;
    }

    @Override
    public void turnOn() {
        decoratedDevice.turnOn();
    }

    @Override
    public void turnOff() {
        decoratedDevice.turnOff();
    }
}