package com.ilionx.carapp.service;

import com.ilionx.carapp.model.Car;
import com.ilionx.carapp.model.Coureur;
import com.ilionx.carapp.persistence.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private Coureur maxVerstappen;

    @Autowired
    private Coureur lewisHamilton;

    @Autowired
    private CarRepository carRepository;

    @Value("@{companyName}")
    private String companyName;

    public List<Car> findAll() {
        System.out.println("Onze bedrijfsnaam is nu " + this.companyName);
        return carRepository.findAll();
    }

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public Optional<Car> findById(Long aLong) {
        return carRepository.findById(aLong);
    }

    public long count() {
        return carRepository.count();
    }

    public void deleteById(Long aLong) {
        carRepository.deleteById(aLong);
    }

    public Optional<Car> updateById (long id, Car input) {
        Optional<Car> optionalCar = this.carRepository.findById(id);
        if (optionalCar.isPresent()) {
            Car target = optionalCar.get();
            target.setLicensePlate(input.getLicensePlate());
            target.setBrand(input.getBrand());
            target.setLicensePlate(input.getLicensePlate());
            this.carRepository.save(target);
        }
        return optionalCar;
    }

    public List<Car> findByLicensePlate(String licensePlate) {
        return carRepository.findByLicensePlate(licensePlate);
    }
    public List<Car> findByMileageLessThan10000() {
        return carRepository.findByMileageLessThan10000();
    }

    public List<Car> findByContainsString(String string) {
        return carRepository.findByContainsString(string);
    }

    public int avgMileageFromBounds(int left, int right) {
        return carRepository.avgMileageFromBounds(left, right);
    }
}
