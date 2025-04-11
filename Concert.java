package concert.concert;

public class Concert {
    private ConcertType type;
    private Venue venue;
    private String date;  // Format: "December 15"
    private String time;  // Format: "8:00 PM"
    private int availableTickets;
    
    public Concert(ConcertType type, Venue venue, String date, String time, int availableTickets) {
        this.type = type;
        this.venue = venue;
        this.date = date;
        this.time = time;
        this.availableTickets = availableTickets;
    }
    
    public ConcertType getType() {
        return type;
    }
    
    public Venue getVenue() {
        return venue;
    }
    
    public String getDate() {
        return date;
    }
    
    public String getTime() {
        return time;
    }
    
    public int getAvailableTickets() {
        return availableTickets;
    }
    
    public void bookTickets(int quantity) {
        if (quantity > availableTickets) {
            throw new IllegalArgumentException("Not enough tickets available");
        }
        availableTickets -= quantity;
    }
    
    public double calculateTotalCost(int quantity) {
        return type.getBasePrice() * quantity;
    }
    
    @Override
    public String toString() {
        return String.format("%s\nVenue: %s\nDate: %s at %s\nAvailable Tickets: %d\nPrice: $%.2f",
                type.getDisplayName(),
                venue,
                date,
                time,
                availableTickets,
                type.getBasePrice());
    }
}