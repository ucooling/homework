import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    //这里保存一个车和认证的Hash，当停车的时候，返回一个Certificate，当取车的时候返回一个Car

    private Integer capacity = 0;
    private Map<Certificate, Car> parkingCar = new HashMap<Certificate, Car>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }


    public Certificate parkingCar(Car car) {
        Certificate certificate = new Certificate(car.getVehicleNo(), this);
        parkingCar.put(certificate, car);
        return certificate;
    }

    public Map<Certificate, Car> getParkingCar() {
        return parkingCar;
    }

    public Boolean isFull() {
        return parkingCar.size() >= capacity;
    }

    public Integer surplusCapacity(){
        return capacity - parkingCar.size();
    }

    public Integer rateSurplusCapacity(){
        return Math.round((capacity - parkingCar.size()) / capacity * 1000000);
    }

    public Car getCar(Certificate certificate) {
        return parkingCar.remove(certificate);
    }

}
