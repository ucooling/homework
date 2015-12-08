import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ParkingManTest {

    @Test
    public void shouldReturnTureCheckOneParkingLotIsFull() {
        ParkingMan parkingMan = new ParkingMan();
        ParkingLot parkingLot = new ParkingLot("parkingLotOne", 1);
        Car car = new Car("陕A66666");
        parkingLot.parkingCar(car);
        assertThat(parkingMan.checkParkingLotIsFull(parkingLot), is(true));
    }

    @Test
    public void shouldReturnFalseCheckOneParkingLotIsNotFull() {
        ParkingMan parkingMan = new ParkingMan();
        ParkingLot parkingLot = new ParkingLot("parkingLotOne", 2);
        Car car = new Car("陕A66666");
        parkingLot.parkingCar(car);
        assertThat(parkingMan.checkParkingLotIsFull(parkingLot), is(false));
    }

    @Test
    public void shouldSetParkingLot(){
        ParkingMan parkingMan = new ParkingMan();
        ParkingLot parkingLot = new ParkingLot("parkingLotOne", 1);
        parkingMan.setParkingLot(parkingLot);
        assertThat(parkingMan.getParkingLotList().get(0), is(parkingLot));
        assertThat(parkingMan.getParkingLotList().size(), is(1));
    }

    @Test
    public void shouldAccordingToOrderPartingCar(){
        //当第一个停车场停满了就会将车停到第二个停车场
        ParkingMan parkingMan = new ParkingMan();
        ParkingLot parkingLotOne = new ParkingLot("parkingLotOne", 2);
        ParkingLot parkingLotTwo = new ParkingLot("parkingLotTwo", 1);
        parkingMan.setParkingLot(parkingLotOne);
        parkingMan.setParkingLot(parkingLotTwo);
        Car carOne = new Car("陕A66666");
        Car carTwo = new Car("陕A66667");
        Car carThree = new Car("陕A66668");
        Certificate certificateOne = parkingMan.parkingCar(carOne);
        Certificate certificateTwo = parkingMan.parkingCar(carTwo);
        Certificate certificateThree = parkingMan.parkingCar(carThree);
        assertThat(certificateOne.getParkingLotName(), is("parkingLotOne"));
        assertThat(certificateTwo.getParkingLotName(), is("parkingLotOne"));
        assertThat(certificateThree.getParkingLotName(), is("parkingLotTwo"));
    }


}
