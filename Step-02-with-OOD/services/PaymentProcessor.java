package services;

import constants.PaymentMethods;

public class PaymentProcessor {
    
    public void executePayment(PaymentMethods method, double amount) {
        switch (method) {
            case CARD:
                processCardPayment(amount);
                break;
            case PAYPAL:
                processPayPalPayment(amount);
                break;
            case CASH:
                processCashPayment(amount);
                break;
            default:
                System.out.println("Payment method not supported!");
        }
    }

    private void processCardPayment(double amount) {
        System.out.println("💳 Card payment processed: $" + amount);
    }

    private void processPayPalPayment(double amount) {
        System.out.println("💼 PayPal payment processed: $" + amount);
    }

    private void processCashPayment(double amount) {
        System.out.println("💵 Cash payment processed: $" + amount);
    }
}

