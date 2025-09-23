public class MediumSpot extends ParkingSpot {
    public MediumSpot(String spotId, RateStrategy rateStrategy) {
        super(spotId, false, rateStrategy);
    }
    public VehicleSize getSpotSize() { return VehicleSize.MEDIUM; }
}