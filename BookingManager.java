package concert.booking;

import concert.concert.Concert;
import concert.user.User;
import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private List<Booking> bookings;
    
    public BookingManager() {
        this.bookings = new ArrayList<>();
    }
    
    public Booking createBooking(User user, Concert concert, int ticketQuantity) {
        Booking booking = new Booking(user, concert, ticketQuantity);
        bookings.add(booking);
        return booking;
    }
    
    public List<Booking> getUserBookings(User user) {
        List<Booking> userBookings = new ArrayList<>();
        for (Booking booking : bookings) {
            if (booking.getUser().equals(user)) {
                userBookings.add(booking);
            }
        }
        return userBookings;
    }
    
    public void displayAllBookings() {
        System.out.println("\n=== ALL BOOKINGS ===");
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }
}