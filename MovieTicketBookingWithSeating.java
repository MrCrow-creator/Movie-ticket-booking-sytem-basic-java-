import java.util.Scanner;

public class MovieTicketBookingWithSeating {
    private static final double BASIC_TICKET_PRICE = 150.00;
    private static final double ROYAL_TICKET_PRICE = 250.00;
    private static final double RECLINER_TICKET_PRICE = 350.00;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Movies available
        String[] movies = {"1. Avengers: Endgame", "2. Joker", "3. Frozen II", "4. The Lion King"};

        // Display available movies
        System.out.println("Welcome to the Movie Ticket Booking System!");
        System.out.println("Please select a movie:");
        for (String movie : movies) {
            System.out.println(movie);
        }

        // Select movie
        System.out.print("Enter the number corresponding to your movie choice: ");
        int movieChoice = scanner.nextInt();
        if (movieChoice < 1 || movieChoice > movies.length) {
            System.out.println("Invalid choice. Exiting...");
            return;
        }
        String selectedMovie = movies[movieChoice - 1].substring(3); // Remove the numbering

        // Display seating arrangement
        displaySeatingArrangement();

        // Choose seats
        System.out.print("\nEnter the seat(s) you want to book (e.g., B-A2, R-B10, Rec-R4): ");
        scanner.nextLine(); // Consume the newline
        String seatSelection = scanner.nextLine();
        String[] seats = seatSelection.split(",\\s*");

        // Calculate total cost based on seat selection
        double totalCost = 0;
        for (String seat : seats) {
            if (seat.matches("[Bb]-[AaCc][1-9]|[Bb]-[Bb][1-9]|[Bb]-[Bb]1[0-4]|[Bb]-[Cc][1-9]|[Bb]-[Cc]1[0-4]")) {
                totalCost += BASIC_TICKET_PRICE;
            } else if (seat.matches("[Rr]-[Aa][1-9]|[Rr]-[Aa]1[0-8]|[Rr]-[Bb][1-9]|[Rr]-[Bb]1[0-9]|[Rr]-[Bb]20")) {
                totalCost += ROYAL_TICKET_PRICE;
            } else if (seat.matches("Rec-[Rr][1-9]|Rec-[Rr]1[0-2]")) {
                totalCost += RECLINER_TICKET_PRICE;
            } else {
                System.out.println("Invalid seat selection: " + seat);
                return;
            }
        }

        // Display booking summary
        System.out.println("\nBooking Summary:");
        System.out.println("Movie: " + selectedMovie);
        System.out.println("Seats: " + seatSelection);
        System.out.println("Total cost: Rs " + totalCost);
        System.out.println("\nThank you for booking with us!");

        scanner.close();
    }

    private static void displaySeatingArrangement() {
        // Display the screen
        System.out.println("                                              SCREEN ");
        System.out.println("_______________________________________________________________________________________\n");

        // Basic Ticket Section
        System.out.println("Basic Ticket (Prefix with 'B')");
        System.out.print("Row A: ");
        for (int i = 1; i <= 9; i++) {
            System.out.print("B-A" + i + "\t");
        }
        System.out.println();

        System.out.print("Row B: ");
        for (int i = 1; i <= 12; i++) {
            System.out.print("B-B" + i + "\t");
        }
        System.out.println();

        System.out.print("Row C: ");
        for (int i = 1; i <= 14; i++) {
            System.out.print("B-C" + i + "\t");
        }
        System.out.println("\n");

        // Royal Ticket Section
        System.out.println("Royal Ticket (Prefix with 'R')");
        System.out.print("Row A: ");
        for (int i = 1; i <= 18; i++) {
            System.out.print("R-A" + i + "\t");
        }
        System.out.println();

        System.out.print("Row B: ");
        for (int i = 1; i <= 20; i++) {
            System.out.print("R-B" + i + "\t");
        }
        System.out.println("\n");

        // Recliner Section
        System.out.println("Recliner (Prefix with 'Rec')");
        System.out.print("Row Royal: ");
        for (int i = 1; i <= 12; i++) {
            System.out.print("Rec-R" + i + "\t");
        }
        System.out.println("\n");

        // Box Section
        System.out.println("Box:");
        System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t");
        for (int i = 1; i <= 3; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
