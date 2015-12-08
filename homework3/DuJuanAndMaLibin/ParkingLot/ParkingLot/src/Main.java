public class Main {

    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot("parkingLotOne", 2);
        Car car = new Car("陕A66666");
        Certificate certificate = parkingLot.parkingCar(car);
        Car gatCar = parkingLot.getCar(certificate);
        System.out.println("*******************");
        System.out.println(gatCar.getVehicleNo());
        System.out.println("*******************");
    }
}
