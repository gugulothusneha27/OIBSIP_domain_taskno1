import java.util.*;

class Reservation {
    int pnr;
    String name;
    String trainNo;
    String trainName;
    String classType;
    String date;
    String from;
    String to;

    Reservation(int pnr, String name, String trainNo, String trainName,
                String classType, String date, String from, String to) {
        this.pnr = pnr;
        this.name = name;
        this.trainNo = trainNo;
        this.trainName = trainName;
        this.classType = classType;
        this.date = date;
        this.from = from;
        this.to = to;
    }

    public void display() {
        System.out.println("\nReservation Details");
        System.out.println("PNR: " + pnr);
        System.out.println("Passenger Name: " + name);
        System.out.println("Train No: " + trainNo);
        System.out.println("Train Name: " + trainName);
        System.out.println("Class: " + classType);
        System.out.println("Journey Date: " + date);
        System.out.println("From: " + from);
        System.out.println("To: " + to);
    }
}

public class OnlineReservationSystem {

    static Scanner sc = new Scanner(System.in);
    static Reservation reservation = null;

    static boolean login() {
        System.out.print("Enter Username: ");
        String user = sc.next();
        System.out.print("Enter Password: ");
        String pass = sc.next();

        if (user.equals("admin") && pass.equals("1234")) {
            System.out.println("Login Successful!");
            return true;
        } else {
            System.out.println("Invalid Login!");
            return false;
        }
    }

    static void reserveTicket() {
        System.out.print("Enter PNR Number: ");
        int pnr = sc.nextInt();
        sc.nextLine();

        System.out.print("Passenger Name: ");
        String name = sc.nextLine();

        System.out.print("Train Number: ");
        String trainNo = sc.nextLine();

        System.out.print("Train Name: ");
        String trainName = sc.nextLine();

        System.out.print("Class Type: ");
        String classType = sc.nextLine();

        System.out.print("Journey Date: ");
        String date = sc.nextLine();

        System.out.print("From: ");
        String from = sc.nextLine();

        System.out.print("To: ");
        String to = sc.nextLine();

        reservation = new Reservation(pnr, name, trainNo, trainName,
                classType, date, from, to);

        System.out.println("\nTicket Reserved Successfully!");
    }

    static void cancelTicket() {
        if (reservation == null) {
            System.out.println("No Reservation Found.");
            return;
        }

        System.out.print("Enter PNR Number to Cancel: ");
        int pnr = sc.nextInt();

        if (reservation.pnr == pnr) {
            reservation.display();
            System.out.print("Confirm Cancellation (Y/N): ");
            char ch = sc.next().charAt(0);

            if (ch == 'Y' || ch == 'y') {
                reservation = null;
                System.out.println("Ticket Cancelled Successfully!");
            } else {
                System.out.println("Cancellation Cancelled.");
            }
        } else {
            System.out.println("Invalid PNR Number.");
        }
    }

    public static void main(String[] args) {

        if (!login())
            return;

        while (true) {
            System.out.println("\n===== ONLINE RESERVATION SYSTEM =====");
            System.out.println("1. Reserve Ticket");
            System.out.println("2. View Reservation");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    reserveTicket();
                    break;
                case 2:
                    if (reservation != null)
                        reservation.display();
                    else
                        System.out.println("No Reservation Available.");
                    break;
                case 3:
                    cancelTicket();
                    break;
                case 4:
                    System.out.println("Thank You!");
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}
