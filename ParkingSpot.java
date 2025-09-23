abstract class ParkingSpot {
    protected String spotId;
    protected boolean isAvailable = true;
    protected boolean chargingFacility;
    protected RateStrategy rateStrategy;
    protected Vehicle vehicle;

    public ParkingSpot(String spotId, boolean chargingFacility, RateStrategy rateStrategy) {
        this.spotId = spotId;
        this.chargingFacility = chargingFacility;
        this.rateStrategy = rateStrategy;
    }

    public boolean isAvailable() { return isAvailable; }
    public boolean hasCharging() { return chargingFacility; }
    public void assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isAvailable = false;
    }
    public void removeVehicle() {
        this.vehicle = null;
        this.isAvailable = true;
    }
    public int getFloor() {
        // First digit of spotId represents floor
        return Integer.parseInt(String.valueOf(spotId.charAt(0)));
    }
    public abstract VehicleSize getSpotSize();
    public String getSpotId() { return spotId; }
}