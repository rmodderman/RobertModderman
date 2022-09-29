package com.ilionx.carapp.persistence;

import com.ilionx.carapp.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByLicensePlate(String licensePlate);
    @Query("select c from Car c where c.mileage < 10000")
    List<Car> findByMileageLessThan10000();

    @Query(value = "SELECT * FROM car WHERE LICENSE_PLATE LIKE %?1%", nativeQuery = true)
    List<Car> findByContainsString(String string);

    @Query(value = "SELECT AVG(MILEAGE) FROM car WHERE MILEAGE <= ?2 AND MILEAGE >= ?1", nativeQuery = true)
    int avgMileageFromBounds(int left, int right);
}
