package org.example.Lab1;

public class ECommerce {
    public static void main(String[] args) {

        /* Example of using the Bitcoin payment method
         1. Open/Closed Principle (OCP):
           The PaymentProcessor class is open for extension and closed for modification.
           We added a new payment method, BitcoinPayment, without changing the PaymentProcessor class.
          This ensures that future payment methods can be introduced easily without altering the core system. */

        PaymentMethod paymentMethod = new BitcoinPayment();
        PaymentProcessor processor = new PaymentProcessor(paymentMethod);
        /*
         * 2. Dependency Inversion Principle (DIP):
         * PaymentProcessor depends on the PaymentMethod abstraction (interface), not a concrete class.
         * This allows us to inject any payment method (e.g., CreditCardPayment, PayPalPayment) into the processor.
         * This follows the DIP by ensuring high-level modules (PaymentProcessor) depend on abstractions, not low-level modules.
         */
        processor.process(300.00);

        // Example of switching to another payment method without modifying existing classes
        paymentMethod = new CreditCardPayment();
        processor = new PaymentProcessor(paymentMethod);
        processor.process(100.00);

        /* 3. Single Responsibility Principle (SRP):
          Each class in the code is responsible for only one thing:
          - PaymentProcessor only processes payments, it doesn’t care about the payment method logic.
         - Each payment method class (e.g., CreditCardPayment, PayPalPayment) handles its own payment-specific logic.
         This follows the SRP by keeping each class focused on a single responsibility. */
    }
}
