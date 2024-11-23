package org.example.Lab3.domain.commands;

import org.example.Lab3.domain.clases.Device;

public class TurnOffCommand implements Command {
    private Device device;

    public TurnOffCommand(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOff();
        System.out.println(device.getName() + " turned OFF.");
    }
}
