# Laboratory Work: Behavioral Design Patterns

---

## Objectives 
**Author**: Grigoraș Dumitru FAF-221
1. Study and understand the Behavioral Design Patterns.
2. As a continuation of the previous laboratory work, think about what communication between software entities might be involed in your system.
3. Implement some additional functionalities using behavioral design patterns.

----

### Introduction
Behavioral design patterns focus on the interaction and communication between objects, ensuring that these interactions are efficient, flexible, and easy to maintain. These patterns are particularly valuable in systems where defining responsibilities, managing workflows, and optimizing communication are essential.

In my laboratory work, I implemented the **Command** behavioral design pattern to enhance the functionality and modularity of my Smart Home System. The functionalities that I implemented are:
-Encapsulation of device operations as commands, enabling flexible execution, queuing, or logging of actions (Command pattern);
-Decoupling of the system's user interface from the logic that controls devices, promoting a clean and scalable architecture;
-Simplification of user interactions by providing consistent methods to control all devices, such as turning them on or off and enabling power-saving features.

---

## Implementation & Explanation

### **Command Pattern**
The **Command Pattern** encapsulates requests as objects, enabling flexible and decoupled execution of operations. It allows for operations to be queued, logged, or even undone, promoting cleaner architecture and reusable commands.

#### Code Snippet
**Command Interface**: `Lab3/domain/commands/Command.java`  
**Concrete Commands**: `Lab3/domain/commands/TurnOnCommand.java`, `Lab2/domain/commands/TurnOffCommand.java`  
**Invoker**: `Lab3/controller/SmartHomeController.java`  

```java
// Command Interface
public interface Command {
    void execute();
}

// Concrete Commands
public class TurnOnCommand implements Command {
    private final Device device;

    public TurnOnCommand(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOn();
    }
}

public class TurnOffCommand implements Command {
    private final Device device;

    public TurnOffCommand(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOff();
    }
}

// Invoker
public class SmartHomeController {
    public void executeCommand(Command command) {
        command.execute();
    }
}
```
#### Motivation:
The Command Pattern was employed to decouple the user interface from the logic that controls devices. Each action, such as turning on or off a device, is encapsulated in a separate command class, making the system more modular and extensible

## Screenshots / Results
In figure 1 is represented the main menu, and also the output of the first butoon

![image](https://github.com/user-attachments/assets/331c147e-18a4-4123-b715-d5e8740a56d6)

_Figure 1. Main menu_

I will not include the functionalit for buttons as turn all all devices or enable powersaving it was described in previous lab [Lab2](https://github.com/qopas/LabsTMSP/blob/86be4ca0310a7644b4495b1396b0f447284105d0/src/main/java/org/example/Lab2/Readme.md)

Figure 2 represent turning on command 

![image](https://github.com/user-attachments/assets/19a08cfc-3c48-433a-80b7-e491969eba3d)

_Figure 2. Turn ON Command_

Figure 3 represent the execute all commands in queue

 ![image](https://github.com/user-attachments/assets/f8d9eafc-5691-4ce6-a118-584edd3640dc)

_Figure 3. Execute all commands in queue_


## Conclusion  
Implementing the **Command Pattern** in the Smart Home System demonstrated the power of behavioral design patterns in creating flexible and modular systems. By decoupling the execution of operations from the interface that triggers them, the system became easier to extend, maintain, and scale. This project showcased how behavioral patterns can provide clean solutions to real-world problems.



