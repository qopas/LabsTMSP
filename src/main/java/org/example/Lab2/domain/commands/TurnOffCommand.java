package org.example.Lab2.domain.commands;

import org.example.Lab2.domain.clases.Device;

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
