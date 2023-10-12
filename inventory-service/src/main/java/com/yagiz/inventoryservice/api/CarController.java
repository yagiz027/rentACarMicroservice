package com.yagiz.inventoryservice.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.yagiz.inventoryservice.business.abstracts.CarService;
import com.yagiz.inventoryservice.business.dtos.requests.create.CreateCarRequest;
import com.yagiz.inventoryservice.business.dtos.requests.update.UpdateCarRequest;
import com.yagiz.inventoryservice.business.dtos.responses.create.CreateCarResponse;
import com.yagiz.inventoryservice.business.dtos.responses.get.GetCarListResponse;
import com.yagiz.inventoryservice.business.dtos.responses.get.GetCarResponse;
import com.yagiz.inventoryservice.business.dtos.responses.update.UpdateCarResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cars")
public class CarController {
    private final CarService carService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCarResponse add(@RequestBody CreateCarRequest createCarRequest) {
        return carService.add(createCarRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UpdateCarResponse update(@PathVariable int id, @RequestBody UpdateCarRequest updateCarRequest) {
        return carService.upate(id, updateCarRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetCarResponse getCarById(@PathVariable int id) {
        return carService.getCarById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetCarListResponse> getCarList() {
        return carService.getCarList();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCarById(@PathVariable int id) {
        carService.deleteCarById(id);
    }
}
