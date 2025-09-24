import java.util.*;
import java.time.LocalDateTime;

// Main class for console interaction
public class ParkingLotConsoleApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingLot parkingLot = new ParkingLot();

        // Setup entry/exit gates
        EntryGate entryGate = new EntryGate();
        ExitGate exitGate = new ExitGate();
        parkingLot.addEntryGate(entryGate);
        parkingLot.addExitGate(exitGate);

        // Setup parking spots (example)
        parkingLot.addSpot(new SmallSpot("101", new SmallSpotRateStrategy()));
        parkingLot.addSpot(new MediumSpot("102", new MediumSpotRateStrategy()));
        parkingLot.addSpot(new LargeSpot("201", true, new LargeSpotRateStrategy())); // Charging spot
        parkingLot.addSpot(new LargeSpot("202", false, new LargeSpotRateStrategy()));

        Map<String, Ticket> activeTickets = new HashMap<>();

        while (true) {
            System.out.println("\n--- Parking Lot Menu ---");
            System.out.println("1. Park Vehicle");
            System.out.println("2. Exit Vehicle");
            System.out.println("3. Show Available Spots");
            System.out.println("4. Quit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    // Park Vehicle
                    System.out.print("Enter Vehicle No: ");
                    String vehicleNo = scanner.nextLine();
                    System.out.print("Enter Vehicle Size (SMALL, MEDIUM, LARGE): ");
                    VehicleSize size = VehicleSize.valueOf(scanner.nextLine().toUpperCase());
                    System.out.print("Needs Charging (true/false): ");
                    boolean charging = scanner.nextBoolean();
                    scanner.nextLine(); // consume newline

                    Vehicle vehicle = new Vehicle(vehicleNo, size, charging);
                    Ticket ticket = parkingLot.assignSpot(vehicle, entryGate);

                    if (ticket != null) {
                        activeTickets.put(ticket.getSpotId(), ticket);
                        System.out.println("Ticket Generated! Spot ID: " + ticket.getSpotId() +
                                " | Entry Time: " + ticket.getEntryTime());
                    } else {
                        System.out.println("No spots available for your vehicle!");
                    }
                    break;

                case 2:
                    // Exit Vehicle
                    System.out.print("Enter Spot ID from Ticket: ");
                    String spotId = scanner.nextLine();
                    Ticket exitTicket = activeTickets.get(spotId);

                    if (exitTicket != null) {
                        Bill bill = parkingLot.releaseSpot(exitTicket, exitGate);
                        activeTickets.remove(spotId);

                        System.out.println("Bill Generated!");
                        System.out.println("Ticket ID: " + exitTicket.getSpotId());
                        System.out.println("Exit Time: " + LocalDateTime.now());
                        System.out.println("Duration (hours): " + bill.getDuration());
                        System.out.println("Amount: $" + bill.getAmount());
                        System.out.println("Used Charging: " + bill.isUsedCharging());
                    } else {
                        System.out.println("Invalid Spot ID!");
                    }
                    break;

                case 3:
                    // Show Available Spots
                    System.out.println("Available Spots:");
                    for (ParkingSpot spot : parkingLot.getSpots().values()) {
                        if (spot.isAvailable()) {
                            System.out.println("Spot ID: " + spot.getSpotId() +
                                    " | Size: " + spot.getSpotSize() +
                                    " | Charging: " + spot.hasCharging() +
                                    " | Floor: " + spot.getFloor());
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
    }
}

