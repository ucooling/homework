import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    //这里保存一个车和认证的Hash，当停车的时候，返回一个Certificate，当取车的时候返回一个Car

    private String name;
    private int capacity = 0;
    private Map<Certificate, Car> parkingCar = new HashMap<Certificate, Car>();

    public ParkingLot(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }


    public Certificate parkingCar(Car car) {
        Certificate certificate = new Certificate(car.getVehicleNo(), name);
        parkingCar.put(certificate, car);
        return certificate;
    }

    public Boolean isFull() {
        return parkingCar.size() >= capacity;
    }

    public Car getCar(Certificate certificate) {
        return parkingCar.remove(certificate);
    }
}
