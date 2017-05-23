package designpatterns.creational.builder;

import org.junit.Assert;
import org.junit.Test;

public class CarBuilderTest {
    @Test
    public void build() throws Exception {
        Car testCar = new Car.CarBuilder(4, "Toyota", "Camry")
                .withColor("White")
                .withCruiseControl(false)
                .withRearViewCamera(true)
                .withSeats(4)
                .build();

        Assert.assertTrue("testCar has rear view camera", testCar.hasRearViewCamera());
    }

}