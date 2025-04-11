package concert;

import concert.booking.Booking;
import concert.booking.BookingManager;
import concert.booking.PaymentProcessor;
import concert.concert.Concert;
import concert.concert.ConcertType;
import concert.concert.Venue;
import concert.payment.CreditCardPayment;
import concert.payment.PaymentMethod;
import concert.payment.UPIPayment;
import concert.user.Customer;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Venue arena = new Venue("Music Arena", "123 Main St, New York", 5000);
        Venue garden = new Venue("Summer Garden", "456 Park Ave, New York", 3000);
        Venue hall = new Venue("City Hall", "789 Center St, New York", 2000);
        
        // Setup concerts with simplified dates
        Concert rockConcert = new Concert(ConcertType.ROCK, arena, "April 15", "8:00 PM", 2000);
        Concert popConcert = new Concert(ConcertType.POP, garden, "April 20", "7:30 PM", 1500);
        Concert jazzConcert = new Concert(ConcertType.JAZZ, hall, "April 10", "6:00 PM", 800);
        
        List<Concert> availableConcerts = List.of(rockConcert, popConcert, jazzConcert);
        
        BookingManager bookingManager = new BookingManager();
        
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== CONCERT TICKET BOOKING SYSTEM ===");
        
        // Get user details
        System.out.print("\nEnter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        
        Customer customer = new Customer(name, email);
        
        // Display available concerts
        System.out.println("\nAVAILABLE CONCERTS THIS MONTH:");
        for (int i = 0; i < availableConcerts.size(); i++) {
            System.out.printf("\n%d. %s", i + 1, availableConcerts.get(i));
        }
        
        // Select concert
        System.out.print("\n\nSelect a concert (1-" + availableConcerts.size() + "): ");
        int concertChoice = scanner.nextInt() - 1;
        Concert selectedConcert = availableConcerts.get(concertChoice);
        
        // Select ticket quantity
        System.out.print("Enter number of tickets: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        // Create booking
        Booking booking = bookingManager.createBooking(customer, selectedConcert, quantity);
        System.out.println("\n=== YOUR BOOKING SUMMARY ===");
        System.out.println(booking);
        
        // Payment
        System.out.println("\nSELECT PAYMENT METHOD:");
        System.out.println("1. Credit Card");
        System.out.println("2. UPI");
        System.out.print("Enter choice: ");
        int paymentChoice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        PaymentMethod paymentMethod = null;
        if (paymentChoice == 1) {
            System.out.print("Enter card number: ");
            String cardNumber = scanner.nextLine();
            System.out.print("Enter card holder name: ");
            String cardHolder = scanner.nextLine();
            System.out.print("Enter expiry date (MM/YY): ");
            String expiryDate = scanner.nextLine();
            System.out.print("Enter CVV: ");
            String cvv = scanner.nextLine();
            
            paymentMethod = new CreditCardPayment(booking.getTotalAmount(), 
                cardNumber, cardHolder, expiryDate, cvv);
        } else if (paymentChoice == 2) {
            System.out.print("Enter UPI ID: ");
            String upiId = scanner.nextLine();
            
            paymentMethod = new UPIPayment(booking.getTotalAmount(), upiId);
        } else {
        	System.out.println("Invalid Choice");
        }
        
        // Process payment
        boolean paymentSuccess = paymentProcessor.processPayment(booking, paymentMethod);
        
        if (paymentSuccess) {
            System.out.println("\n=== BOOKING CONFIRMED ===");
            System.out.println(booking);
            System.out.println("\nThank you for your purchase!");
        }
        
        scanner.close();
    }
}