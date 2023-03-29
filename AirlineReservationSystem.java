import java.util.Scanner;

public class AirlineReservationSystem {
    // Array to hold the seats of the airplane
    private static boolean[] seats = new boolean[10];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Print the menu options
            System.out.println("\nMenu:");
            System.out.println("1. Reserve a Seat");
            System.out.println("2. Cancel a Reservation");
            System.out.println("3. View Seat Map");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    reserveSeat();
                    break;
                case 2:
                    cancelReservation();
                    break;
                case 3:
                    viewSeatMap();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void reserveSeat() {
        Scanner scanner = new Scanner(System.in);

        // Check if there are any available seats
        if (isFlightFull()) {
            System.out.println("Sorry, the flight is full.");
            return;
        }

        // Ask for the passenger's name
        System.out.print("Enter passenger name: ");
        String name = scanner.nextLine();

        // Assign a seat to the passenger
        int seatNumber = assignSeat();

        // Print the boarding pass
        System.out.println("\nBoarding Pass:");
        System.out.println("Passenger Name: " + name);
        System.out.println("Seat Number: " + seatNumber);
    }

    private static void cancelReservation() {
        Scanner scanner = new Scanner(System.in);

        // Ask for the seat number to cancel
        System.out.print("Enter seat number to cancel: ");
        int seatNumber = scanner.nextInt();

        // Check if the seat is valid and already reserved
        if (seatNumber < 1 || seatNumber > 10) {
            System.out.println("Invalid seat number. Please try again.");
            return;
        }
        if (!seats[seatNumber - 1]) {
            System.out.println("This seat is not reserved. Please try again.");
            return;
        }

        // Cancel the reservation
        seats[seatNumber - 1] = false;
        System.out.println("Reservation cancelled successfully.");
    }

    private static void viewSeatMap() {
        System.out.println("\nSeating Chart:");
        for (int i = 0; i < seats.length; i++) {
            String status = seats[i] ? "X" : "O";
            System.out.println("Seat " + (i+1) + ": " + status);
        }
    }

    private static int assignSeat() {
        for (int i = 0; i < seats.length; i++) {
            if (!seats[i]) {
                seats[i] = true;
                return i + 1;
            }
        }
        return -1;
    }

    private static boolean isFlightFull() {
        for (boolean seat : seats) {
            if (!seat) {
                return false;
            }
        }
        return true;
    }
}
