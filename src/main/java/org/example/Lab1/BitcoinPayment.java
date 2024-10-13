package org.example.Lab1;

public class BitcoinPayment implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Bitcoin payment of $" + amount);
    }
}
