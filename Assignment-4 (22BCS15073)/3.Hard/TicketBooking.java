class TicketBookingSystem {
    private int availableSeats = 5; // Total available seats

    // Synchronized method to book a seat
    public synchronized void bookTicket(String name, int tickets) {
        if (tickets <= availableSeats) {
            System.out.println(name + " booked " + tickets + " ticket(s).");
            availableSeats -= tickets;
        } else {
            System.out.println(name + " failed to book. Not enough seats.");
        }
    }
}

// Thread class for booking tickets
class BookingThread extends Thread {
    private TicketBookingSystem system;
    private String name;
    private int tickets;

    public BookingThread(TicketBookingSystem system, String name, int tickets, int priority) {
        this.system = system;
        this.name = name;
        this.tickets = tickets;
        setPriority(priority); // Set thread priority (higher for VIP)
    }

    public void run() {
        system.bookTicket(name, tickets);
    }
}

public class TicketBooking {
    public static void main(String[] args) {
        TicketBookingSystem system = new TicketBookingSystem();

        // Creating threads (VIP and Regular)
        BookingThread vip1 = new BookingThread(system, "VIP-1", 2, Thread.MAX_PRIORITY);
        BookingThread regular1 = new BookingThread(system, "Regular-1", 1, Thread.NORM_PRIORITY);
        BookingThread vip2 = new BookingThread(system, "VIP-2", 1, Thread.MAX_PRIORITY);
        BookingThread regular2 = new BookingThread(system, "Regular-2", 2, Thread.MIN_PRIORITY);

        // Start all threads
        vip1.start();
        regular1.start();
        vip2.start();
        regular2.start();
    }
}