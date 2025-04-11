package concert.payment;

public interface PaymentMethod {
    boolean processPayment(double amount);
    String getPaymentDetails();
}