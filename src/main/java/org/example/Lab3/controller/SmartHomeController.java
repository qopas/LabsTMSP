package org.example.Lab3.controller;

import org.example.Lab3.domain.clases.Device;
import org.example.Lab3.domain.clases.Thermostat;

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

    public List<Device> getDevices() {
        return devices;
    }

    public void addDevice(Device device) {
        devices.add(device);
    }

    public void removeDevice(Device device) {
        devices.remove(device);
    }
}
