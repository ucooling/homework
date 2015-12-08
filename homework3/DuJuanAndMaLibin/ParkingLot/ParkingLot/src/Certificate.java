import java.util.Date;

public class Certificate {
    //提供一个唯一的证明，用这个证明可以在停车场取到自己的车

    private final String id;
    private final String vehicleNo;
    private final String parkingLotName;

    public Certificate(String vehicleNo, String parkingLotName) {
        this.parkingLotName = parkingLotName;
        this.vehicleNo = vehicleNo;
        this.id = new Date().toString();
    }

    public String getParkingLotName() {
        return parkingLotName;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public String getId() {
        return id;
    }
}
