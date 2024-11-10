# Laboratory Work: Structural Design Patterns

**Author**: Grigoraș Dumitru FAF-221

---

## Objectives 

**Objective**:
1. Study and understand Structural Design Patterns.
2. Build upon the functionalities implemented in the previous laboratory work by identifying and integrating necessary additional features.
3. Use Structural Design Patterns to implement these features, enhancing code reusability, flexibility, and maintainability.

---

### Introduction
Structural design patterns enable developers to compose objects and classes into larger, more manageable structures, helping clarify relationships within complex systems. These patterns are particularly useful in systems where code organization and scalability are crucial.

In my laboratory work, I implemented three structural patterns—**Adapter**, **Decorator**, and **Facade**—to enhance the functionalities and structure of my Smart Home System. The functionalities that I implemented are:

- Integration of third-party devices, ensuring compatibility with the system (uses the **Adapter** pattern);
- Adding advanced device behaviors such as logging and power-saving features (uses the **Decorator** pattern);
- Streamlining device management with simplified controls for user interaction (uses the **Facade** pattern).

---

## Implementation & Explanation

### 1. **Adapter Pattern**
The **Adapter Pattern** is used to integrate a third-party device into the existing system, allowing it to communicate seamlessly with other components. It provides a way to make incompatible interfaces compatible, ensuring the system can extend its device support without modifying existing code.

#### Code Snippet
**ThirdPartyDevice**: `Lab2/domain/clases/ThirdPartyDevice.java`
**ThirdPartyDeviceAdapter**: `Lab2/domain/adapters/ThirdPartyDeviceAdapter.java`
```java
// Third-party device interface
public class ThirdPartyDevice {
    public void activate() {
        System.out.println("Third-party device activated.");
    }
    public void deactivate() {
        System.out.println("Third-party device deactivated.");
    }
}

public class ThirdPartyDeviceAdapter extends Device {
    private ThirdPartyDevice thirdPartyDevice;

    public ThirdPartyDeviceAdapter(ThirdPartyDevice device) {
        this.thirdPartyDevice = device;
    }

    @Override
    public void turnOn() {
        thirdPartyDevice.activate();
    }

    @Override
    public void turnOff() {
        thirdPartyDevice.deactivate();
    }
}
```
#### Motivation:
The Adapter Pattern is beneficial here as it helps integrate a device(third - party device) with a different interface, making it compatible with the Device interface in the SmartHome system.

### 2. **Decorator Pattern**
#### LoggingDecorator
The `LoggingDecorator` adds logging capability to any `Device` instance. Each time a device is turned on or off, it logs the action with the device's name.
**Location**: `Lab2/domain/decorator/LoggingDecorator`
#### Code Snippet
```java
public class LoggingDecorator extends DeviceDecorator {
    public LoggingDecorator(Device device) {
        super(device);
    }

    @Override
    public void turnOn() {
        System.out.println("Logging: Turning on " + decoratedDevice.getName());
        super.turnOn();
    }

    @Override
    public void turnOff() {
        System.out.println("Logging: Turning off " + decoratedDevice.getName());
        super.turnOff();
    }
}
```
#### PowerSavingDecorator
The `PowerSavingDecorator` adds power-saving mode features. Devices with this decorator can toggle power-saving mode on or off and will notify when operating in this mode.
**Location**: `Lab2/domain/decorator/PowerSavingDecorator`
#### Code Snippet
```java
public class PowerSavingDecorator extends DeviceDecorator implements PowerSavingDevice {
    public PowerSavingDecorator(Device device) {
        super(device);
    }

    @Override
    public void enablePowerSaving() {
        System.out.println("Power-saving mode enabled for " + decoratedDevice.getName());
    }

    @Override
    public void disablePowerSaving() {
        System.out.println("Power-saving mode disabled for " + decoratedDevice.getName());
    }

    @Override
    public void turnOn() {
        super.turnOn();
        System.out.println(decoratedDevice.getName() + " is operating in power-saving mode.");
    }
}
```
#### Motivation:
PowerSavingDecorator provides a way to add power-saving functionality to devices dynamically. This is helpful for optimizing energy usage in devices.

### 3. **Facade Pattern**

The **Facade Pattern** is used to provide a simplified interface to a complex subsystem, making it easier for clients to interact with the system without needing to understand its internal details. In the Smart Home System, the `SmartHomeFacade` class serves as a simplified interface for managing multiple devices through the `SmartHomeController`.

#### Implementation Details
The `SmartHomeFacade` class encapsulates interactions with various devices, providing easy-to-use methods for common actions like turning on/off all devices and enabling power-saving mode. This reduces the complexity of device management in the client code (`Main` class) by delegating operations to the facade, improving modularity and readability.

#### Key Methods in `SmartHomeFacade`
- **turnAllDevicesOn()**: Turns on all devices managed by the `SmartHomeController`.
- **turnAllDevicesOff()**: Turns off all devices.
- **enablePowerSavingMode()**: Enables power-saving mode on all compatible devices.


For example, instead of managing each device directly, the following code in `Main` now leverages the facade:

```java
// Using facade to turn all devices on
facade.turnAllDevicesOn();

// Using facade to enable power-saving mode
facade.enablePowerSavingMode();
```
#### Motivation:
Changes to device management are centralized in the facade, minimizing the impact on client code
---
## Screenshots / Results
In figure 1 is represented the main menu, and also the output of the first butoon

![image](https://github.com/user-attachments/assets/331c147e-18a4-4123-b715-d5e8740a56d6)

_Figure 1. Main menu_

Figure 2 and 3 showing the functionality of second button turning all device of smarthouse on

![image](https://github.com/user-attachments/assets/819243ee-094d-46f0-bca4-31ca02462f41)

_Figure 2. Second option of Menu_

![image](https://github.com/user-attachments/assets/9a184385-14af-4e1d-bd22-6c9c169c4746)

_Figure 3. Logging system_

Figure 4 showing the functionality of enabling powersaving

![image](https://github.com/user-attachments/assets/ddabc9d9-8435-4f50-bb87-b6f5e53026b8)

_Figure 4. Enable of power saving_

## Conclusion
Working with structural design patterns in the Smart Home System really highlighted how useful these patterns are for building organized and adaptable systems.  Using these patterns made the Smart Home System more flexible, maintainable, and ready for future updates. This project was a great way to see how design patterns can solve real-world coding challenges, creating a system that’s both powerful and easy to expand.



