package com.yagiz.inventoryservice.repository;

import com.yagiz.inventoryservice.entity.Car;
import com.yagiz.inventoryservice.entity.enums.State;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Integer> {
    State getStateById(int carId);
}
