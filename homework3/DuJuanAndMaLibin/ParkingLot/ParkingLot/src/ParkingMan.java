import java.util.ArrayList;

public class ParkingMan {
    private static ArrayList parkingLotList = new ArrayList();
    private static int index = 0;

    public Boolean checkParkingLotIsFull(ParkingLot parkinglot) {
        return parkinglot.isFull();
    }

    public static ArrayList getParkingLotList() {
        return parkingLotList;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        parkingLotList.add(parkingLot);
    }

    public Certificate parkingCar(Car car){
        Certificate certificate = null;
        if(!(((ParkingLot)parkingLotList.get(index)).isFull())){
            certificate = ((ParkingLot)parkingLotList.get(index)).parkingCar(car);
            if(index < parkingLotList.size()-1){
                index++;
            }
        }
        return certificate;
    }
}
