package com.yagiz.invoiceservice.api.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.yagiz.invoiceservice.business.abstracts.InvoiceService;
import com.yagiz.invoiceservice.business.dtos.responses.get.GetInvoiceListResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/invoices")
public class InvoiceController {
    private final InvoiceService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetInvoiceListResponse> getList(){
        return service.getInvoiceList();
    }
}
