public interface RateStrategy {
    double calculateAmount(long duration, ParkingSpot spot, boolean usedCharging);
}
