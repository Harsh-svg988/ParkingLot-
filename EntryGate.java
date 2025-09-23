import java.util.UUID;

class EntryGate extends Gate {
    public Ticket generateTicket(Vehicle vehicle, ParkingSpot spot) {
        spot.assignVehicle(vehicle);
        return new Ticket(UUID.randomUUID().toString(), vehicle.getVehicleNo(), spot.getSpotId());
    }
}
