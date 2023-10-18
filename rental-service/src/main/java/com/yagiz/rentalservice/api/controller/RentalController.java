package com.yagiz.rentalservice.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.yagiz.rentalservice.business.abstracts.RentalService;
import com.yagiz.rentalservice.business.dtos.requests.CreateRentalRequest;
import com.yagiz.rentalservice.business.dtos.requests.UpdateRentalRequests;
import com.yagiz.rentalservice.business.dtos.responses.CreateRentalResponses;
import com.yagiz.rentalservice.business.dtos.responses.UpdateRentalResponses;
import com.yagiz.rentalservice.business.dtos.responses.get.GetRentalListResponses;
import com.yagiz.rentalservice.business.dtos.responses.get.GetRentalResponses;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/rentals")
@RequiredArgsConstructor
public class RentalController {
    private final RentalService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateRentalResponses add(@RequestBody CreateRentalRequest rentalRequest){
        return service.add(rentalRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UpdateRentalResponses update(@PathVariable int id, @RequestBody UpdateRentalRequests rentalRequests){
        return service.update(id,rentalRequests);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetRentalResponses getRentalById(int id){
        return service.getRentalById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetRentalListResponses> getRentalList(){
        return service.getRentalList();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(int id){
        service.deleteById(id);
    }
}
