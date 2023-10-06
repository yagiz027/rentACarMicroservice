package com.yagiz.inventoryservice.repository;

import com.yagiz.inventoryservice.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Integer> {
}
