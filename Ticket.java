import java.time.LocalDateTime;

class Ticket {
    private String ticketId;
    private String vehicleNo;
    private String spotId;
    private LocalDateTime entryTime;

    public Ticket(String ticketId, String vehicleNo, String spotId) {
        this.ticketId = ticketId;
        this.vehicleNo = vehicleNo;
        this.spotId = spotId;
        this.entryTime = LocalDateTime.now();
    }

    public LocalDateTime getEntryTime() { return entryTime; }
    public String getSpotId() { return spotId; }
}