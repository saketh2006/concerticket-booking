package concert.payment;

public abstract class Payment implements PaymentMethod {
    protected String transactionId;
    protected double amount;
    
    public Payment(double amount) {
        this.amount = amount;
        this.transactionId = generateTransactionId();
    }
    
    protected abstract String generateTransactionId();
    
    public String getTransactionId() {
        return transactionId;
    }
    
    @Override
    public String getPaymentDetails() {
        return String.format("Transaction ID: %s, Amount: $%.2f", transactionId, amount);
    }
}