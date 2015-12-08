import org.junit.Test;

import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ParkingLotTest {

    @Test
    public void shouldReturnFalseWhenIsFull() throws Exception {
        ParkingLot parkingLot = new ParkingLot("parkingLotOne", 1);
        Car car = new Car("陕A66666");
        parkingLot.parkingCar(car);
        assertThat(parkingLot.isFull(), is(true));
    }

    @Test
    public void shouldReturnTrueWhenIsNotFull() throws Exception {
        ParkingLot parkingLot = new ParkingLot("parkingLotOne", 2);
        Car car = new Car("陕A66666");
        parkingLot.parkingCar(car);
        assertThat(parkingLot.isFull(), is(false));
    }

    @Test
    public void shouldReturnCorrectCertificate(){
        ParkingLot parkingLot = new ParkingLot("parkingLotOne", 2);
        Car car = new Car("陕A66666");
        Certificate certificate = parkingLot.parkingCar(car);
        assertThat(certificate.getVehicleNo(), is("陕A66666"));
    }

    @Test
    public void shouldReturnCorrectCar(){
        ParkingLot parkingLot = new ParkingLot("parkingLotOne", 2);
        Car car = new Car("陕A66666");
        Certificate certificate = parkingLot.parkingCar(car);
        Car gatCar = parkingLot.getCar(certificate);
        assertThat(gatCar.getVehicleNo(), is("陕A66666"));
    }


}
