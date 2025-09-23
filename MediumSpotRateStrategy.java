public class MediumSpotRateStrategy implements RateStrategy {
    public double calculateAmount(long duration, ParkingSpot spot, boolean usedCharging) {
        return duration * 20 + (usedCharging ? 10 : 0);
    }
}