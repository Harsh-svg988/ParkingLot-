public class LargeSpot extends ParkingSpot {
    public LargeSpot(String spotId, boolean chargingFacility, RateStrategy rateStrategy) {
        super(spotId, chargingFacility, rateStrategy);
    }
    public VehicleSize getSpotSize() { return VehicleSize.LARGE; }
}