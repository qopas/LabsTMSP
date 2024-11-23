package org.example.Lab3.domain.commands;


import java.util.LinkedList;
import java.util.Queue;

public class CommandExecutor {
    private Queue<Command> commandQueue = new LinkedList<>();

    public void addCommand(Command command) {
        commandQueue.add(command);
    }

    public void executeAll() {
        while (!commandQueue.isEmpty()) {
            Command command = commandQueue.poll();
            command.execute();
        }
    }
}

