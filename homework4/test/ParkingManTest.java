import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ParkingManTest {
    private ParkingMan parkingMan;

    @Before
    public void setUpData(){
        parkingMan = new ParkingMan();
    }

    @Test
    public void shouldReturnTureCheckOneParkingLotIsFull() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car("陕A66666");
        parkingLot.parkingCar(car);
        assertThat(parkingMan.checkParkingLotIsFull(parkingLot), is(true));
    }

    @Test
    public void shouldReturnFalseCheckOneParkingLotIsNotFull() {
        ParkingLot parkingLot = new ParkingLot(2);
        Car car = new Car("陕A66666");
        parkingLot.parkingCar(car);
        assertThat(parkingMan.checkParkingLotIsFull(parkingLot), is(false));
    }

    @Test
    public void shouldSetParkingLot(){
        ParkingLot parkingLot = new ParkingLot(1);
        parkingMan.setParkingLot(parkingLot);
        assertThat(parkingMan.getParkingLotList().get(0), is(parkingLot));
        assertThat(parkingMan.getParkingLotList().size(), is(1));
    }

    @Test
    public void shouldAccordingToOrderPartingCar(){
        //当第一个停车场停满了就会将车停到第二个停车场
        ParkingLot parkingLotOne = new ParkingLot(2);
        ParkingLot parkingLotTwo = new ParkingLot(1);
        parkingMan.setParkingLot(parkingLotOne);
        parkingMan.setParkingLot(parkingLotTwo);
        Car carOne = new Car("陕A66666");
        Car carTwo = new Car("陕A66667");
        Car carThree = new Car("陕A66668");
        Certificate certificateOne = parkingMan.parkingCar(carOne);
        Certificate certificateTwo = parkingMan.parkingCar(carTwo);
        Certificate certificateThree = parkingMan.parkingCar(carThree);
        assertThat(certificateOne.getParkingLot(), is(parkingLotOne));
        assertThat(certificateTwo.getParkingLot(), is(parkingLotOne));
        assertThat(certificateThree.getParkingLot(), is(parkingLotTwo));
    }

    @Test
    public void shouldGetCarWhenUseCertificate(){
        ParkingMan parkingMan = new ParkingMan();
        ParkingLot parkingLotOne = new ParkingLot(1);
        parkingMan.setParkingLot(parkingLotOne);
        Car carOne = new Car("陕A66666");
        Car carTwo = new Car("陕A66667");
        parkingMan.parkingCar(carTwo);
        Certificate certificate = parkingMan.parkingCar(carOne);
        Car car = parkingMan.getCar(certificate);
        assertThat(car, is(carOne));
    }


}
