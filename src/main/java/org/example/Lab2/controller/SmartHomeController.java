package org.example.Lab2.controller;

import org.example.Lab2.domain.clases.Device;
import org.example.Lab2.domain.clases.Light;
import org.example.Lab2.domain.clases.Thermostat;
import org.example.Lab2.domain.clases.PowerSavingDevice;

import java.util.ArrayList;
import java.util.List;

/**
 * SmartHomeController is a Singleton class responsible for managing all smart home devices.
 * It ensures there is only one instance of the controller in the application.
 */
public class SmartHomeController {
    private static SmartHomeController instance;
    private List<Device> devices = new ArrayList<>();

    private SmartHomeController() {}
    /**
     * Provides access to the single instance of SmartHomeController.
     * Uses lazy initialization to create the instance when it’s first accessed.
     *
     * @return the single instance of SmartHomeController
     */
    public static synchronized SmartHomeController getInstance() {
        if (instance == null) {
            instance = new SmartHomeController();
        }
        return instance;
    }

    public void addDevice(Device device) {
        devices.add(device);
    }

    public void removeDevice(Device device) {
        devices.remove(device);
    }

    public List<Device> getDevices() {
        return devices;
    }
    public void showDevices() {
        if (devices.isEmpty()) {
            System.out.println("No devices available.");
        } else {
            for (Device device : devices) {
                System.out.println(device.getName() + " - " + device.getStatus());
            }
        }
    }

    // Toggle device on/off based on device name
    public void toggleDevice(String deviceName, boolean turnOn) {
        for (Device device : devices) {
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
        for (Device device : devices) {
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
        for (Device device : devices) {
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
        for (Device device : devices) {
            if (device instanceof PowerSavingDevice) {
                PowerSavingDevice psDevice = (PowerSavingDevice) device;
                psDevice.enablePowerSaving();
            }
        }
        System.out.println("Power-saving mode enabled for compatible devices.");
    }

    // Disable power-saving mode for devices
    public void disablePowerSaving() {
        for (Device device : devices) {
            if (device instanceof PowerSavingDevice) {
                PowerSavingDevice psDevice = (PowerSavingDevice) device;
                psDevice.disablePowerSaving();
            }
        }
        System.out.println("Power-saving mode disabled for compatible devices.");
    }
}
