package org.example.Lab0;

public class BankTransferPayment implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing bank transfer payment of $" + amount);
    }
}