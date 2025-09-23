class Vehicle {
    private String vehicleNo;
    private VehicleSize sizeRequired;
    private boolean needsCharging;

    public Vehicle(String vehicleNo, VehicleSize sizeRequired, boolean needsCharging) {
        this.vehicleNo = vehicleNo;
        this.sizeRequired = sizeRequired;
        this.needsCharging = needsCharging;
    }

    public String getVehicleNo() { return vehicleNo; }
    public VehicleSize getSizeRequired() { return sizeRequired; }
    public boolean needsCharging() { return needsCharging; }
}
