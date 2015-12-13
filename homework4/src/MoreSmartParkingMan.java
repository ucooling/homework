import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MoreSmartParkingMan implements ParkingBoy {
    private static ArrayList parkingLots = new ArrayList();

    @Override
    public void setParkingLot(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }

    public void sortParkingLot(){
        Collections.sort(parkingLots, new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                ParkingLot parkingLot1 = (ParkingLot)o1;
                ParkingLot parkingLot2 = (ParkingLot)o2;
                return parkingLot1.rateSurplusCapacity().compareTo(parkingLot2.rateSurplusCapacity());
            }
        });
        Collections.reverse(parkingLots);
    }

    @Override
    public Certificate parkingCar(Car car) {
        Certificate certificate = null;
        sortParkingLot();
        if (!((ParkingLot) parkingLots.get(0)).isFull()) {
            certificate = ((ParkingLot) parkingLots.get(0)).parkingCar(car);
        }
        return certificate;
    }

    @Override
    public Car getCar(Certificate certificate) {
        return certificate.getParkingLot().getCar(certificate);
    }
}
