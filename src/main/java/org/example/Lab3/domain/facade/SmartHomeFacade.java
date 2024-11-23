package org.example.Lab3.domain.facade;

import org.example.Lab3.controller.SmartHomeController;
import org.example.Lab3.domain.clases.Device;
import org.example.Lab3.domain.clases.Light;
import org.example.Lab3.domain.clases.PowerSavingDevice;
import org.example.Lab3.domain.clases.Thermostat;

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
    public void showDevices() {
        if (controller.getDevices().isEmpty()) {
            System.out.println("No devices available.");
        } else {
            for (Device device : controller.getDevices()) {
                System.out.println(device.getName() + " - " + device.getStatus());
            }
        }
    }

    // Toggle device on/off based on device name
    public void toggleDevice(String deviceName, boolean turnOn) {
        for (Device device : controller.getDevices()) {
            if (device.getName().equalsIgnoreCase(deviceName)) {
                device.setStatus(turnOn);
                System.out.println(deviceName + " is now " + device.getStatus());
                return;
            }
        }
        System.out.println("Device not found.");
    }

    // Adjust light brightness
    public void adjustLightBrightness(String lightName, int brightness) {
        for (Device device : controller.getDevices()) {
            if (device instanceof Light && device.getName().equalsIgnoreCase(lightName)) {
                Light light = (Light) device;
                light.setBrightness(brightness);
                System.out.println("Brightness of " + lightName + " set to " + brightness + "%.");
                return;
            }
        }
        System.out.println("Light device not found or incorrect name.");
    }

    // Set thermostat temperature
    public void setThermostatTemperature(String thermostatName, double temperature) {
        for (Device device : controller.getDevices()) {
            if (device instanceof Thermostat && device.getName().equalsIgnoreCase(thermostatName)) {
                Thermostat thermostat = (Thermostat) device;
                thermostat.setTemperature((int) temperature);
                System.out.println("Temperature of " + thermostatName + " set to " + temperature + "°C.");
                return;
            }
        }
        System.out.println("Thermostat device not found or incorrect name.");
    }

    // Enable power-saving mode for devices
    public void enablePowerSaving() {
        for (Device device : controller.getDevices()) {
            if (device instanceof PowerSavingDevice) {
                PowerSavingDevice psDevice = (PowerSavingDevice) device;
                psDevice.enablePowerSaving();
            }
        }
        System.out.println("Power-saving mode enabled for compatible devices.");
    }

    // Disable power-saving mode for devices
    public void disablePowerSaving() {
        for (Device device : controller.getDevices()) {
            if (device instanceof PowerSavingDevice) {
                PowerSavingDevice psDevice = (PowerSavingDevice) device;
                psDevice.disablePowerSaving();
            }
        }
        System.out.println("Power-saving mode disabled for compatible devices.");
    }
}
