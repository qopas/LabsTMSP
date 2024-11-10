package org.example.Lab2.domain.facade;

import org.example.Lab2.controller.SmartHomeController;
import org.example.Lab2.domain.clases.Device;
import org.example.Lab2.domain.clases.PowerSavingDevice;

public class SmartHomeFacade {
    private SmartHomeController controller;

    public SmartHomeFacade(SmartHomeController controller) {
        this.controller = controller;
    }

    public void turnAllDevicesOn() {
        System.out.println("Turning all devices on...");
        controller.getDevices().forEach(Device::turnOn);
    }

    public void turnAllDevicesOff() {
        System.out.println("Turning all devices off...");
        controller.getDevices().forEach(Device::turnOff);
    }

    public void enablePowerSavingMode() {
        System.out.println("Enabling power-saving mode for all devices...");
        controller.getDevices().forEach(device -> {
            if (device instanceof PowerSavingDevice) {
                ((PowerSavingDevice) device).enablePowerSaving();
            }
        });
    }
}
