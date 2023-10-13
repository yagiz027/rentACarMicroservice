package com.yagiz.inventoryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.yagiz.inventoryservice.entity.Car;
import com.yagiz.inventoryservice.entity.enums.State;

import jakarta.transaction.Transactional;

public interface CarRepository extends JpaRepository<Car, Integer> {
    State getStateById(int carId);

    @Modifying
    @Transactional
    @Query(value = "update Car set state = :state where id = :id")
    void changeStateByCarId(State state, int id);
}
