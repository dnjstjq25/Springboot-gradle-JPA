package com.use.gradle.repository;

import com.use.gradle.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface CarRepository extends JpaRepository<Car, String> {

    @Query("SELECT c from Car as c where c.car_number = ?1")
    Car selectCar(String car_number);

    @Modifying
    @Transactional
    @Query("update Car c set c.car_status = ?1 where c.car_number = ?2")
    void updateCar(String car_status, String car_number);
}
