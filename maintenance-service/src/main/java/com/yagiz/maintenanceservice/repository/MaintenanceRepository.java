package com.yagiz.maintenanceservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yagiz.maintenanceservice.entity.Maintenance;

public interface MaintenanceRepository extends JpaRepository<Maintenance,Integer>{
    
}
