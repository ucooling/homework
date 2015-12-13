import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ParkingLotTest {

    private ParkingLot parkingLot;
    private Car carOne;
    private Car carTwo;
    @Before
    public void setUpData(){
        parkingLot = new ParkingLot(2);
        carOne = new Car("陕A66666");
        carTwo = new Car("陕A66667");
    }

    @Test
    public void shouldReturnFalseWhenIsFull() throws Exception {
        parkingLot.parkingCar(carOne);
        parkingLot.parkingCar(carTwo);
        assertThat(parkingLot.isFull(), is(true));
    }

    @Test
    public void shouldReturnTrueWhenIsNotFull() throws Exception {
        parkingLot.parkingCar(carOne);
        assertThat(parkingLot.isFull(), is(false));
    }

    @Test
    public void shouldReturnCorrectCertificate(){
        Certificate certificate = parkingLot.parkingCar(carOne);
        assertThat(certificate.getVehicleNo(), is("陕A66666"));
    }

    @Test
    public void shouldReturnCorrectCar(){
        Certificate certificate = parkingLot.parkingCar(carOne);
        Car gatCar = parkingLot.getCar(certificate);
        assertThat(gatCar.getVehicleNo(), is("陕A66666"));
    }


}
