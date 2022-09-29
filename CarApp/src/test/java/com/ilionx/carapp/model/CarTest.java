package com.ilionx.carapp.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CarTest {
    private Car car;

    @BeforeEach
    public void setup() {
        car = new Car();
    }

    @Test
    public void testGetSetBrand() {
        final String expectedName = "Mercedes";
        car.setBrand(expectedName);
        Assertions.assertEquals(expectedName, car.getBrand());
    }

    @Test
    public void testGetSetMileage () {
        final double expectedMileage = 12093;
        car.setMileage(expectedMileage);
        Assertions.assertEquals(expectedMileage, car.getMileage());
    }

    @Test
    public void testGetSetLicensePlate () {
        final String expectedLicensePlate = "HTNJ32";
        car.setLicensePlate(expectedLicensePlate);
        Assertions.assertEquals(expectedLicensePlate, car.getLicensePlate());
    }
}
