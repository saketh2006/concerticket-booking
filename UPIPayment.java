package concert.payment;

public class UPIPayment extends Payment {
    private String upiId;
    
    public UPIPayment(double amount, String upiId) {
        super(amount);
        this.upiId = upiId;
    }
    
    @Override
    protected String generateTransactionId() {
        return "UPI-" + System.currentTimeMillis();
    }
    
    @Override
    public boolean processPayment(double amount) {
        System.out.printf("Processing UPI payment of $%.2f to %s\n", amount, upiId);
        return true;
    }
    
    @Override
    public String getPaymentDetails() {
        return super.getPaymentDetails() + "\nUPI ID: " + upiId;
    }
}