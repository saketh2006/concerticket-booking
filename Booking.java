package concert.booking;

import concert.concert.Concert;
import concert.user.User;

public class Booking {
    private String bookingId;
    private User user;
    private Concert concert;
    private int ticketQuantity;
    private double totalAmount;
    private boolean isConfirmed;
    
    public Booking(User user, Concert concert, int ticketQuantity) {
        this.user = user;
        this.concert = concert;
        this.ticketQuantity = ticketQuantity;
        this.totalAmount = concert.calculateTotalCost(ticketQuantity);
        this.bookingId = "BK-" + System.currentTimeMillis();
        this.isConfirmed = false;
    }
    
    public void confirmBooking() {
        concert.bookTickets(ticketQuantity);
        this.isConfirmed = true;
    }
    
    public String getBookingId() {
        return bookingId;
    }
    
    public User getUser() {
        return user;
    }
    
    public Concert getConcert() {
        return concert;
    }
    
    public int getTicketQuantity() {
        return ticketQuantity;
    }
    
    public double getTotalAmount() {
        return totalAmount;
    }
    
    public boolean isConfirmed() {
        return isConfirmed;
    }
    
    @Override
    public String toString() {
        return String.format(
            "=== Booking Confirmation ===\n" +
            "Booking ID: %s\n" +
            "Customer: %s\n" +
            "Concert: %s\n" +
            "Date: %s at %s\n" +
            "Tickets: %d\n" +
            "Total Amount: $%.2f\n" +
            "Status: %s\n" +
            "===========================",
            bookingId,
            user.getName(),
            concert.getType().getDisplayName(),
            concert.getDate(),
            concert.getTime(),
            ticketQuantity,
            totalAmount,
            isConfirmed ? "CONFIRMED" : "PENDING PAYMENT"
        );
    }
}