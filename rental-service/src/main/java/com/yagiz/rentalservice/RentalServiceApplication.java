package com.yagiz.rentalservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.yagiz.commonservice.utils.PathFinder.Paths;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {Paths.ConfigurationBasePackage,Paths.Rental.ServiceBasePackage})
public class RentalServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(RentalServiceApplication.class, args);
	}
}
