package com.ilionx.carapp.api;

import com.ilionx.carapp.model.Car;
import com.ilionx.carapp.persistence.CarRepository;
import com.ilionx.carapp.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/cars")
public class CarController {
    @Autowired
    private CarService carService;
    @Autowired
    private CarRepository carRepository;

    @GetMapping
    public ResponseEntity<Iterable<Car>> cars () {
        return ResponseEntity.ok(carService.findAll());
    }

    @PostMapping
    public ResponseEntity<Car> create(@RequestBody Car car) {
        return ResponseEntity.ok(this.carService.save(car));
    }

    @GetMapping("{id}")
    public ResponseEntity<Car> findById(@PathVariable long id) {
        Optional<Car> carOptional = this.carService.findById(id);
        return carOptional.isPresent() ? ResponseEntity.ok(carOptional.get())
                : ResponseEntity.notFound().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Car> updateById(@PathVariable long id, @RequestBody Car source) {
        Optional<Car> carOptional = this.carService.findById(id);
        if(carOptional.isPresent()) {
            Car target = carOptional.get();
            target.setBrand(source.getBrand());
            target.setMileage(source.getMileage());
            target.setLicensePlate(source.getLicensePlate());
            return ResponseEntity.ok(this.carService.save(target));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        Optional<Car> carOptional = this.carService.findById(id);
        if (carOptional.isPresent()) {
            this.carService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("licensePlate/{licensePlate}")
    public List<Car> findByLicensePlate(@PathVariable String licensePlate) {
        return carService.findByLicensePlate(licensePlate);
    }

    @GetMapping("fewKMs")
    public List<Car> findByMileageLessThan10000() {
        return carService.findByMileageLessThan10000();
    }

    @GetMapping("containsString/{string}")
    public List<Car> findByContainsString(@PathVariable String string) {
        return carService.findByContainsString(string);
    }

    @GetMapping("avgMileage/{left}/{right}")
    public int avgMileageFromBounds(@PathVariable int left, @PathVariable int right) {
        return carService.avgMileageFromBounds(left, right);
    }
}
