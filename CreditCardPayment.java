package concert.payment;

public class CreditCardPayment extends Payment {
    private String cardNumber;
    private String cardHolder;
    private String expiryDate;
    private String cvv;
    
    public CreditCardPayment(double amount, String cardNumber, String cardHolder, String expiryDate, String cvv) {
        super(amount);
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }
    
    @Override
    protected String generateTransactionId() {
        return "CC-" + System.currentTimeMillis();
    }
    
    @Override
    public boolean processPayment(double amount) {
        System.out.printf("Processing credit card payment of $%.2f\n", amount);
        return true;
    }
    
    @Override
    public String getPaymentDetails() {
        return super.getPaymentDetails() + 
               String.format("\nCard: ****-****-****-%s\nHolder: %s", 
                   cardNumber.substring(cardNumber.length() - 4), 
                   cardHolder);
    }
}