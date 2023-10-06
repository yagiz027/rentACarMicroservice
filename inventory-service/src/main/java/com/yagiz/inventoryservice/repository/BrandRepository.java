package com.yagiz.inventoryservice.repository;

import com.yagiz.inventoryservice.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand,Integer> {
}
