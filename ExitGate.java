import java.time.LocalDateTime;
import java.util.UUID;

class ExitGate extends Gate {
    public Bill generateBill(Ticket ticket, ParkingSpot spot) {
        long duration = java.time.Duration.between(ticket.getEntryTime(), LocalDateTime.now()).toHours();
        boolean usedCharging = spot.hasCharging() && spot.vehicle.needsCharging();
        double amount = spot.rateStrategy.calculateAmount(duration, spot, usedCharging);
        spot.removeVehicle();
        return new Bill(UUID.randomUUID().toString(), ticket.getSpotId(), duration, amount, usedCharging);
    }
}
