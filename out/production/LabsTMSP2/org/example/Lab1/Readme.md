# Smart Home System - Design Patterns Implementation

## Laboratory Work 1

---

### Table of Contents

1. [Introduction](#introduction)
2. [Features](#features)
3. [Design Patterns Applied](#design-patterns-applied)
   - [Singleton Pattern](#singleton-pattern)
   - [Builder Pattern](#builder-pattern)
   - [Factory Method Pattern](#factory-method-pattern)
4. [Project Structure](#project-structure)
5. [Usage](#usage)
6. [Conclusion](#conclusion)
7. [Author](#author)

---

### Introduction

Welcome to the **Smart Home System** project. This project demonstrates the implementation of several design patterns to manage a home automation system. The patterns used include Singleton, Builder, and Factory Method, which make the system extensible, modular, and easy to maintain.

---

### Features

- **Centralized Smart Home Controller**: Manages all smart devices (lights, thermostats, etc.) in the system.
- **Device Control**: Easily add, remove, and manage devices like lights and thermostats.
- **Flexible Device Creation**: Use of the Builder pattern for device configurations.
- **Device Factories**: Add new device types seamlessly with the Factory Method pattern.
- **Single Instance Control**: The Singleton pattern ensures a unique controller instance.

---

### Design Patterns Applied

#### Singleton Pattern

The Singleton pattern ensures that a class has only one instance and provides a global access point to it. In this project, `SmartHomeController` is implemented as a Singleton, serving as the central hub for controlling all smart devices.

##### Implementation

```java
public class SmartHomeController {
    private static SmartHomeController instance;

    // Private constructor prevents instantiation from other classes
    private SmartHomeController() {}

    // Method to retrieve the single instance
    public static synchronized SmartHomeController getInstance() {
        if (instance == null) {
            instance = new SmartHomeController();
        }
        return instance;
    }
}
```
**Explanation**
-Private Constructor: Restricts instantiation outside of the class.
-Lazy Initialization: getInstance() only creates the instance when first accessed.
-Synchronized Method: Ensures thread safety, preventing multiple instances in multithreaded scenarios.

#### Builder Pattern

The Builder pattern allows the construction of complex objects in a flexible way, especially when there are many optional parameters. In this project, the Light use the Builder pattern to customize properties like brightness.
##### Implementation

```java
(Light class)
public static class Builder extends Device.Builder<Builder> {
        private int brightness = 0;

        public Builder brightness(int brightness) {
            this.brightness = brightness;
            return this;
        }

        @Override
        public Light build() {
            Light light = new Light();
            light.name = this.name;
            light.status = this.status;
            light.brightness = this.brightness;
            return light;
        }
    }

```
**Explanation**
-Nested Builder Class: Provides a fluent interface for constructing Light instances with custom settings.
-Optional Parameters: brightness defaults to 0 if not specified.
-Fluent Setters: Methods like brightness(int brightness) set properties and return the builder, enabling chaining.
-Build Method: Finalizes the object creation by returning a fully configured Light instance.
**Example**
```java
Light livingRoomLight = new Light.Builder()
    .name("Living Room Light")
    .status(true)
    .brightness(70)
    .build();
```

#### Factory Pattern

The Factory Method pattern defines an interface for creating objects, allowing subclasses to decide the specific class to instantiate. Here, DeviceFactory provides a common interface, while LightFactory and ThermostatFactory are concrete implementations.

##### Implementation
**Device Factory Interface**
```java
public interface DeviceFactory {
    Device createDevice();
}

```
**LightFactory Class:**
```java
public class LightFactory implements DeviceFactory {
    @Override
    public Device createDevice() {
        return new Light.Builder()
                .name("Generic Light")
                .status(false)
                .brightness(50)
                .build();
    }
}
```
**Explanation**
-Interface Definition: DeviceFactory standardizes the creation process.
-Concrete Factories: Each factory class (LightFactory) implements DeviceFactory, defining device-specific creation.
-Flexible Instantiation: New device types can be added easily by creating new factory classes without modifying existing code.

**Example**
```java
DeviceFactory lightFactory = new LightFactory();
Device light = lightFactory.createDevice();
```
### Project Structure
Directory Breakdown
```bash
Lab2/ 
├── controller/ 
│ └── SmartHomeController.java # Singleton Smart Home controller 
├── device/ 
│ ├── Device.java # Abstract device class 
│ └── Light.java # Light device with Builder pattern 
├── factory/ 
│ ├── DeviceFactory.java # Factory method interface 
│ └── LightFactory.java
```

### Conclusion
This Smart Home System project demonstrates how the Singleton, Builder, and Factory Method patterns create a maintainable, extensible, and scalable architecture. Each pattern addresses a different aspect of software design, allowing seamless integration of new devices and features while keeping the codebase clean and organized.

### Author
Grigoraș Dumitru FAF-221
