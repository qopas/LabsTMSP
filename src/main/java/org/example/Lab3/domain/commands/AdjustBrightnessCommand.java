package org.example.Lab3.domain.commands;

import org.example.Lab3.domain.clases.Device;

public class AdjustBrightnessCommand implements Command {
    private Device device;
    private int brightness;

    public AdjustBrightnessCommand(Device device, int brightness) {
        this.device = device;
        this.brightness = brightness;
    }

    @Override
    public void execute() {
        if (device instanceof org.example.Lab3.domain.clases.Light) {
            ((org.example.Lab3.domain.clases.Light) device).setBrightness(brightness);
            System.out.println("Brightness of " + device.getName() + " set to " + brightness + "%.");
        } else {
            System.out.println("Device is not a light.");
        }
    }
}
