package com.use.gradle.controller;

import com.use.gradle.model.Car;
import com.use.gradle.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class CarController {

    @Autowired
    CarRepository carRepository;

    @RequestMapping("/allcar")
    public List<Car> list(){

        return carRepository.findAll();
    }

    @RequestMapping("/onecar")
    public Optional<Car> list(@RequestBody Car car){

        return carRepository.findById(car.getCar_number());
    }

    @RequestMapping("/addcar")
    public Car addCar(@RequestBody Car car){

        return carRepository.save(car);
    }

    @RequestMapping("/updatecar")
    public Map<String, Object> updateCar(@RequestBody Car car){
        Map<String, Object> result = new HashMap<>();

        carRepository.updateCar(car.getCar_status(), car.getCar_number());

        result.put("Update", carRepository.selectCar(car.getCar_number()));
        result.put("msg","Update Complete");

        return result;
    }

    @RequestMapping("/deletecar")
    public Map<String, Object> deleteCar(@RequestBody Car car){
        Map<String, Object> result = new HashMap<>();

        carRepository.deleteById(car.getCar_number());

        result.put("msg","Delete Complete");

        return result;
    }
}
