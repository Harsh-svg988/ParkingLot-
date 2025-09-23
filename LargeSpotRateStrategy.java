public class LargeSpotRateStrategy implements RateStrategy {
    public double calculateAmount(long duration, ParkingSpot spot, boolean usedCharging) {
        return duration * 30 + (usedCharging ? 15 : 0);
    }
}
