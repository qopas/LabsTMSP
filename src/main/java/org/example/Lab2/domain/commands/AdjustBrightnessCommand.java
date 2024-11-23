package org.example.Lab2.domain.commands;

import org.example.Lab2.domain.clases.Device;
import org.example.Lab2.domain.clases.Light;

public class AdjustBrightnessCommand implements Command {
    private Device device;
    private int brightness;

    public AdjustBrightnessCommand(Device device, int brightness) {
        this.device = device;
        this.brightness = brightness;
    }

    @Override
    public void execute() {
        if (device instanceof Light) {
            ((Light) device).setBrightness(brightness);
            System.out.println("Brightness of " + device.getName() + " set to " + brightness + "%.");
        } else {
            System.out.println("Device is not a light.");
        }
    }
}
