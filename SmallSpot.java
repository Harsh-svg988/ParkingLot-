
public class SmallSpot extends ParkingSpot {
    public SmallSpot(String spotId, RateStrategy rateStrategy) {
        super(spotId, false, rateStrategy);
    }
    public VehicleSize getSpotSize() { return VehicleSize.SMALL; }
}