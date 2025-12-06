package services;

import constants.Notifier;
import constants.PaymentMethods;
import models.Customer;

public class ReservationService {
    private PaymentProcessor paymentProcessor;
    private MessageSender messageSender;

    public ReservationService() {
        this.paymentProcessor = new PaymentProcessor();
    }

    public void createReservation(Reservation reservation, PaymentMethods paymentMethod, Notifier notificationType) {
        System.out.println("Starting reservation process for " + reservation.getCustomer().getName());

        applyLocationBasedDiscount(reservation);
        executePaymentProcess(paymentMethod, reservation.getTotalPrice());
        generateInvoice(reservation);
        sendConfirmationNotification(notificationType, reservation.getCustomer());
    }

    private void applyLocationBasedDiscount(Reservation reservation) {
        Customer customer = reservation.getCustomer();
        if (customer.isLocatedIn("Paris")) {
            System.out.println("Paris location discount applied!");
            reservation.getRoom().applyDiscount(0.9);
        }
    }

    private void executePaymentProcess(PaymentMethods method, double amount) {
        paymentProcessor.executePayment(method, amount);
    }

    private void generateInvoice(Reservation reservation) {
        System.out.println("========== INVOICE ==========");
        System.out.println("Customer: " + reservation.getCustomer().getName());
        System.out.println("Room: " + reservation.getRoom().getNumber() + " (" + reservation.getRoom().getType() + ")");
        System.out.println("Nights: " + reservation.getNights());
        System.out.println("Total Amount: $" + reservation.getTotalPrice());
        System.out.println("=============================");
    }

    private void sendConfirmationNotification(Notifier type, Customer customer) {
        messageSender = createMessageSender(type);
        if (messageSender != null) {
            String recipient = getRecipient(type, customer);
            messageSender.deliver(recipient, "Your hotel reservation has been successfully confirmed!");
        }
    }

    private MessageSender createMessageSender(Notifier type) {
        switch (type) {
            case EMAIL:
                return new EmailSender();
            case SMS:
                return new SmsSender();
            default:
                System.out.println("Notification type not supported.");
                return null;
        }
    }

    private String getRecipient(Notifier type, Customer customer) {
        return type == Notifier.EMAIL ? customer.getEmail() : customer.getMobile();
    }
}

