package com.yagiz.inventoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yagiz.commonservice.utils.PathFinder.Paths;

@SpringBootApplication(scanBasePackages = {Paths.ConfigurationBasePackage,Paths.Inventory.ServiceBasePackage})
public class InventoryServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
}
