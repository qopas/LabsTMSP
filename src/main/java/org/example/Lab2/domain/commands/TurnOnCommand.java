package org.example.Lab2.domain.commands;

import org.example.Lab2.domain.clases.Device;

public class TurnOnCommand implements Command {
    private Device device;

    public TurnOnCommand(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOn();
        System.out.println(device.getName() + " turned ON.");
    }
}
