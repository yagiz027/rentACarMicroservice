package com.yagiz.rentalservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yagiz.rentalservice.entity.Rental;

public interface RentalRepository extends JpaRepository<Rental,Integer>{
     
}
