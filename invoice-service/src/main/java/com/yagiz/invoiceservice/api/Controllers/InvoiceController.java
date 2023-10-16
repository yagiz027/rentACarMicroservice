package com.yagiz.invoiceservice.api.Controllers;

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

import com.yagiz.invoiceservice.business.abstracts.InvoiceService;
import com.yagiz.invoiceservice.business.dtos.requests.CreateInvoiceRequest;
import com.yagiz.invoiceservice.business.dtos.requests.UpdateInvoiceRequest;
import com.yagiz.invoiceservice.business.dtos.responses.CreateInvoiceResponse;
import com.yagiz.invoiceservice.business.dtos.responses.UpdateInvoiceResponse;
import com.yagiz.invoiceservice.business.dtos.responses.get.GetInvoiceListResponse;
import com.yagiz.invoiceservice.business.dtos.responses.get.GetInvoiceResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/invoices")
public class InvoiceController {
    private final InvoiceService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateInvoiceResponse add(@RequestBody CreateInvoiceRequest request){
        return service.add(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UpdateInvoiceResponse update(@PathVariable int id, @RequestBody UpdateInvoiceRequest request){
        return service.update(id, request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetInvoiceListResponse> getList(){
        return service.getInvoiceList();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetInvoiceResponse getInvoiceById(@PathVariable int id){
        return service.getInvoiceById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable int id){
        service.deleteById(id);
    }
}
