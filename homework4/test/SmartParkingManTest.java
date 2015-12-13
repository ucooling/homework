import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SmartParkingManTest {
    private SmartParkingMan smartParkingMan;
    private ParkingLot parkingLotOne;
    private ParkingLot parkingLotTwo;
    private ParkingLot parkingLotThree;

    @Before
    public void prepareData() {
        smartParkingMan = new SmartParkingMan();
        parkingLotOne = new ParkingLot(3);
        parkingLotTwo = new ParkingLot(1);
        parkingLotThree = new ParkingLot(3);
        smartParkingMan.setParkingLot(parkingLotTwo);
        smartParkingMan.setParkingLot(parkingLotOne);
        smartParkingMan.setParkingLot(parkingLotThree);
    }

    @Test
    public void shouldParkingCarToCapacityMaximumParkingLot() {
        Car carOne = new Car("陕A66666");
        Car carTwo = new Car("陕A66667");
        Car carThree = new Car("陕A66668");
        Car carFour = new Car("陕A66669");
        Car carFive = new Car("陕A66660");
        smartParkingMan.parkingCar(carOne);
        smartParkingMan.parkingCar(carTwo);
        smartParkingMan.parkingCar(carThree);
        smartParkingMan.parkingCar(carFour);
        Certificate certificate = smartParkingMan.parkingCar(carFive);
        assertThat(certificate.getParkingLot(), is(parkingLotThree));
    }

    @Test
    public void shouldGetCarWhenUseCertificate(){
        Car carOne = new Car("陕A66666");
        Car carTwo = new Car("陕A66667");
        smartParkingMan.parkingCar(carTwo);
        Certificate certificate = smartParkingMan.parkingCar(carOne);
        Car car = smartParkingMan.getCar(certificate);
        assertThat(car, is(carOne));
    }
}
