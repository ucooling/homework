import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MoreSmartParkingManTest {
    private MoreSmartParkingMan moreSmartParkingMan;
    private ParkingLot parkingLotOne;
    private ParkingLot parkingLotTwo;
    private ParkingLot parkingLotThree;

    @Before
    public void prepareData() {
        moreSmartParkingMan = new MoreSmartParkingMan();
        parkingLotOne = new ParkingLot(3);
        parkingLotTwo = new ParkingLot(1);
        parkingLotThree = new ParkingLot(3);
        moreSmartParkingMan.setParkingLot(parkingLotTwo);
        moreSmartParkingMan.setParkingLot(parkingLotOne);
        moreSmartParkingMan.setParkingLot(parkingLotThree);
    }

    @Test
    public void shouldParkingCarToCapacityMaximumParkingLot() {
        Car carOne = new Car("陕A66666");
        Car carTwo = new Car("陕A66667");
        Car carThree = new Car("陕A66668");
        moreSmartParkingMan.parkingCar(carOne);
        Certificate certificateFive = moreSmartParkingMan.parkingCar(carTwo);
        moreSmartParkingMan.parkingCar(carThree);
        assertThat(certificateFive.getParkingLot(), is(parkingLotTwo));
    }

    @Test
    public void shouldGetCarWhenUseCertificate(){
        Car carOne = new Car("陕A66666");
        Car carTwo = new Car("陕A66667");
        moreSmartParkingMan.parkingCar(carTwo);
        Certificate certificate = moreSmartParkingMan.parkingCar(carOne);
        Car car = moreSmartParkingMan.getCar(certificate);
        assertThat(car, is(carOne));
    }

}
