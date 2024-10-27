package org.example.Lab2;
import org.example.Lab2.controller.SmartHomeController;
import org.example.Lab2.device.Device;
import org.example.Lab2.factory.DeviceFactory;
import org.example.Lab2.factory.LightFactory;

/**
 * The Smart Home System project simulates a setup where
 * various smart home devices are managed by a central controller.
 * It leverages the Singleton, Builder, and Factory Method design
 * patterns for efficient code management and extensibility.
 *
 */

public class Main {
    public static void main(String[] args) {
        // Get the single instance of SmartHomeController
        SmartHomeController controller = SmartHomeController.getInstance();

        // Use factories to create device instances
        DeviceFactory lightFactory = new LightFactory();
        Device light = lightFactory.createDevice();

        controller.addDevice(light);

        controller.showDevices();
    }
}
