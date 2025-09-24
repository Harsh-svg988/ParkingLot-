import java.time.LocalDateTime;

class Bill {
    private String billId;
    private String ticketId;
    private LocalDateTime exitTime;
    private long duration;
    private double amount;
    private boolean usedCharging;

    public Bill(String billId, String ticketId, long duration, double amount, boolean usedCharging) {
        this.billId = billId;
        this.ticketId = ticketId;
        this.exitTime = LocalDateTime.now();
        this.duration = duration;
        this.amount = amount;
        this.usedCharging = usedCharging;
    }
    public String getBillId() { return billId; }
    public String getTicketId() { return ticketId; }
    public LocalDateTime getExitTime() { return exitTime; }
    public long getDuration() { return duration; }
    public double getAmount() { return amount; }
    public boolean isUsedCharging() { return usedCharging; }
}