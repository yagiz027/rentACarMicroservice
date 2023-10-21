package com.yagiz.paymentservice.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.yagiz.commonservice.utils.dto.ClientResponse;
import com.yagiz.commonservice.utils.dto.CreateRentalPaymentRequest;
import com.yagiz.paymentservice.business.abstracts.PaymentService;
import com.yagiz.paymentservice.business.dtos.requests.CreatePaymentRequest;
import com.yagiz.paymentservice.business.dtos.requests.UpdatePaymentRequest;
import com.yagiz.paymentservice.business.dtos.responses.CreatePaymentResponse;
import com.yagiz.paymentservice.business.dtos.responses.UpdatePaymentResponse;
import com.yagiz.paymentservice.business.dtos.responses.get.GetPaymentListResponse;
import com.yagiz.paymentservice.business.dtos.responses.get.GetPaymentResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/payments")
public class PaymentController {
    private final PaymentService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatePaymentResponse add(@RequestBody CreatePaymentRequest request){
        return service.add(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UpdatePaymentResponse update(@PathVariable int id, @RequestBody UpdatePaymentRequest request){
        return service.update(id, request);        
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public GetPaymentResponse getPaymentById(@PathVariable int id){
        return service.getPaymentById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetPaymentListResponse> getPaymentList(){
        return service.getPaymentList();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable int id){
        service.deleteById(id);
    }

    @PostMapping("process-rental-payment/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientResponse paymentProcessForRental(CreateRentalPaymentRequest rentalPaymentRequest){
        return service.paymentProcessForRental(rentalPaymentRequest);
    }
}
