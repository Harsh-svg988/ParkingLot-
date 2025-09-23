import java.util.*;
public class ParkingLot {
    private Map<String, ParkingSpot> spots = new HashMap<>();
    private List<EntryGate> entryGates = new ArrayList<>();
    private List<ExitGate> exitGates = new ArrayList<>();

    public void addSpot(ParkingSpot spot) { spots.put(spot.getSpotId(), spot); }
    public void addEntryGate(EntryGate gate) { entryGates.add(gate); }
    public void addExitGate(ExitGate gate) { exitGates.add(gate); }

    public ParkingSpot getNearestSpot(Vehicle vehicle, EntryGate gate) {
        // Prioritize charging if vehicle needs it
        List<ParkingSpot> candidates = new ArrayList<>();
        for(ParkingSpot spot : spots.values()) {
            if(spot.isAvailable() && spot.getSpotSize().ordinal() >= vehicle.getSizeRequired().ordinal()) {
                if(vehicle.needsCharging() && spot.hasCharging()) {
                    candidates.add(0, spot); // put charging spots at front
                } else {
                    candidates.add(spot);
                }
            }
        }
        return candidates.isEmpty() ? null : candidates.get(0);
    }

    public Ticket assignSpot(Vehicle vehicle, EntryGate gate) {
        ParkingSpot spot = getNearestSpot(vehicle, gate);
        if(spot != null) return gate.generateTicket(vehicle, spot);
        return null;
    }

    public Bill releaseSpot(Ticket ticket, ExitGate gate) {
        ParkingSpot spot = spots.get(ticket.getSpotId());
        if(spot != null) return gate.generateBill(ticket, spot);
        return null;
    }
}
