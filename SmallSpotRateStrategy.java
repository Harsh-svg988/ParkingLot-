public class SmallSpotRateStrategy implements RateStrategy {
    public double calculateAmount(long duration, ParkingSpot spot, boolean usedCharging) {
        return duration * 10 + (usedCharging ? 5 : 0);
    }
}
