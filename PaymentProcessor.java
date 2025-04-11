 package concert.booking;

import concert.payment.PaymentMethod;

public class PaymentProcessor {
    public boolean processPayment(Booking booking, PaymentMethod paymentMethod) {
        if (booking.isConfirmed()) {
            System.out.println("Booking is already confirmed");
            return false;
        }
        
        System.out.println("\nProcessing payment...");
        boolean paymentSuccess = paymentMethod.processPayment(booking.getTotalAmount());
        
        if (paymentSuccess) {
            booking.confirmBooking();
            System.out.println("Payment successful!");
            System.out.println(paymentMethod.getPaymentDetails());
            return true;
        } else {
            System.out.println("Payment failed. Please try again.");
            return false;
        }
    }
}