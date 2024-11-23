package org.example.Lab3.domain.decorator;

import org.example.Lab3.domain.clases.Device;

public class LoggingDecorator extends DeviceDecorator {

    public LoggingDecorator(Device device) {
        super(device);
    }

    @Override
    public void turnOn() {
        System.out.println("Logging: Turning on " + decoratedDevice.getName());
        super.turnOn();
    }

    @Override
    public void turnOff() {
        System.out.println("Logging: Turning off " + decoratedDevice.getName());
        super.turnOff();
    }
}