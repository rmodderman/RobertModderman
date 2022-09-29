package com.ilionx.carapp.testing;

import com.ilionx.carapp.model.Car;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("integrationtest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CarApiIT {
    @Autowired
    private TestRestTemplate restTemplate;
    public static final String url = "/api/cars";
    public static long currentId = -1;

    @Test
    @Order(1)
    public void testSaving() {
        Car car = new Car();
        car.setLicensePlate("123456");
        car.setBrand("Kia");
        car.setMileage(123123);

        ResponseEntity<Car> response = this.restTemplate.postForEntity(url, car, Car.class);
        assertEquals(200,response.getStatusCodeValue());

        Car returnedCar = response.getBody();
        assertNotNull(returnedCar);
        assertNotEquals(0, returnedCar.getId());
        assertEquals("KIA", returnedCar.getBrand());
        currentId = returnedCar.getId();
    }

    @Test
    @Order(2)
    public void testGetById() {
        /*Car car = new Car();
        car.setMileage(108000);
        car.setBrand("Volvo");
        car.setLicensePlate("PUTINISGESTOORD");*/

        ResponseEntity<Car> response = this.restTemplate.getForEntity(url + "/" + currentId, Car.class);
        assertNotNull(response.getBody());
        Car responsedCar = response.getBody();
        assertEquals(currentId, responsedCar.getId());
    }
}
