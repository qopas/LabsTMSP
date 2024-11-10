# E-commerce Payment System

This project demonstrates the implementation of three SOLID principles using a simple e-commerce payment system. The system supports multiple types of payments: Credit Card, PayPal, Bank Transfer, and Bitcoin. Each payment type adheres to the Single Responsibility Principle (SRP), Open/Closed Principle (OCP), and Dependency Inversion Principle (DIP) from the SOLID design principles.

## Project Structure
**E-commerce Payment System - SOLID Principles Implementation**  
Laboratory Work 1  

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [SOLID Principles Applied](#solid-principles-applied)
  - [Single Responsibility Principle (SRP)](#single-responsibility-principle-srp)
  - [Open/Closed Principle (OCP)](#openclosed-principle-ocp)
  - [Dependency Inversion Principle (DIP)](#dependency-inversion-principle-dip)
- [Project Structure](#project-structure)
  - [Directory Breakdown](#directory-breakdown)
- [Usage](#usage)
  - [Running the Application](#running-the-application)
- [Author](#author)

## Introduction
Welcome to the E-commerce Payment System project, developed as part of Laboratory Work 1. This project demonstrates the practical application of three SOLID principles—Single Responsibility Principle (SRP), Open/Closed Principle (OCP), and Dependency Inversion Principle (DIP)—to build a maintainable, scalable, and robust payment processing system. The system is designed to handle multiple payment types, such as Credit Card, PayPal, Bank Transfer, and Bitcoin.

## Features
- **Credit Card Payments**: Process payments using credit card details.
- **PayPal Payments**: Process payments via PayPal accounts.
- **Bank Transfer Payments**: Process payments using direct bank transfers.
- **Bitcoin Payments**: Process payments with Bitcoin.
- **Extensibility**: Easily add new payment types (e.g., Apple Pay) without modifying existing code.
- **Modularity**: Each component has a well-defined responsibility, enhancing code readability and maintainability.
- **Logging**: Integrated logging for tracking payment processing details and errors.
- **Configuration Management**: Centralized configuration for setting up payment channels and services.

## SOLID Principles Applied

### Single Responsibility Principle (SRP)
- **Definition**: A class should have only one reason to change, meaning it should have only one job or responsibility.
- **Implementation in the Project**:
  - **PaymentProcessor**: Only responsible for processing a payment, without managing payment-specific details.
  - **PaymentMethod Implementations**: Each payment class (CreditCardPayment, PayPalPayment, BankTransferPayment, BitcoinPayment) only handles its payment type.
  - **Logger**: A separate class manages all logging functionalities, keeping business logic focused solely on payment processing.
  
```java
// Single Responsibility: Each Payment class only processes its payment type.
public class CreditCardPayment implements PaymentMethod {
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}
```

### Open/Closed Principle (OCP)
 - **Definition: Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.
 - **Implementation in the Project:
   - **PaymentMethod Interface: Defines a common interface for all payment types, allowing new payment types to be added without altering existing classes.
   - **Extensible Payment Classes: New payment types, like BitcoinPayment, can be added by implementing the PaymentMethod interface.

```java
// Open for extension, closed for modification: Adding BitcoinPayment class without modifying existing code.
public class BitcoinPayment implements PaymentMethod {
    public void processPayment(double amount) {
        System.out.println("Processing Bitcoin payment of $" + amount);
    }
}
```
### Dependency Inversion Principle (DIP)
 - **Definition: High-level modules should depend on abstractions, not on low-level modules.
 - **Implementation in the Project:
   - **PaymentProcessor: Relies on the PaymentMethod interface rather than specific payment implementations.
   - **Dependency Injection: Payment methods are injected into the PaymentProcessor, allowing for flexible payment type selection.

```java
// Dependency Injection: Injecting different payment methods into PaymentProcessor.
public class PaymentProcessor {
    private final PaymentMethod paymentMethod;

    public PaymentProcessor(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void process(double amount) {
        paymentMethod.processPayment(amount);
    }
}
```

### Project Structure
Directory Breakdown
```bash
Lab1/
|── PaymentProcessor.java           # Handles processing logic, follows DIP
├── PaymentMethod.java              # Abstract interface for payment methods
├── CreditCardPayment.java          # SRP-compliant, Credit card payment
├── PayPalPayment.java              # SRP-compliant, PayPal payment
├── BankTransferPayment.java        # SRP-compliant, Bank transfer payment
└── BitcoinPayment.java             # SRP-compliant, Bitcoin payment
├── Main.java                       # Entry point for the applicationn
pom.xml                             # Project dependencies
```
## Usage:
### Example output:
```bash
Processing credit card payment of $100.00
Processing PayPal payment of $200.00
Processing Bitcoin payment of $300.00
```
## Conclusion:
The E-commerce Payment System project serves as an example of how the fundamental ideas of SOLID can be used to create a flexible, extensible, and maintainable payment processing system. I have structured the system to facilitate the seamless integration of new payment methods and provide a way that reduces feature complexity, facilitates system scalability, and requires minimal code modifications for new features. This improves the system's robustness and adaptability in real-world use situations while simultaneously adhering to clean code standards.
## Author:
**Grigoraș Dumitru FAF-221**
