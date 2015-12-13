import java.util.Date;

public class Certificate {
    //提供一个唯一的证明，用这个证明可以在停车场取到自己的车

    private final String id;
    private final String vehicleNo;
    private final ParkingLot parkingLot;

    public Certificate(String vehicleNo, ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        this.vehicleNo = vehicleNo;
        this.id = new Date().toString();
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public String getId() {
        return id;
    }
}
