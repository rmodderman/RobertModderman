package com.ilionx.carapp.service;

import com.ilionx.carapp.model.Car;
import com.ilionx.carapp.persistence.CarRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {
    @InjectMocks
    private CarService carService;

    @Mock
    private CarRepository carRepository;

    @Test
    public void testSave () {
        // Given
        Car car = new Car();
        car.setMileage(123056);
        car.setBrand("Toyota");
        car.setLicensePlate("THIERRYISGEK");

        Mockito.when(this.carRepository.save(car)).thenReturn(car);

        // When
        Car result = this.carService.save(car);

        // Then
        assertEquals(123056, result.getMileage());
    }

    @Test
    public void testFindAll () {
        // Given
        Car car = new Car();
        //Mockito.when(this.carRepository.findAll()).thenReturn(new ArrayList<Car>(Arrays.asList(car)));
        Mockito.when(this.carRepository.findAll()).thenReturn(Collections.singletonList(car));

        // When
        List<Car> resultFromService = this.carService.findAll();

        // Then
        assertEquals(1, resultFromService.size());
    }
}
