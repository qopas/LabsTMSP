package org.example.Lab2.domain.decorator;

import org.example.Lab2.domain.clases.Device;
import org.example.Lab2.domain.clases.PowerSavingDevice;

public class PowerSavingDecorator extends DeviceDecorator implements PowerSavingDevice {

    public PowerSavingDecorator(Device device) {
        super(device);
    }

    @Override
    public void enablePowerSaving() {
        System.out.println("Power-saving mode enabled for " + decoratedDevice.getName());
    }

    @Override
    public void disablePowerSaving() {
        System.out.println("Power-saving mode disabled for " + decoratedDevice.getName());
    }

    @Override
    public void turnOn() {
        super.turnOn();
        System.out.println(decoratedDevice.getName() + " is operating in power-saving mode.");
    }
}