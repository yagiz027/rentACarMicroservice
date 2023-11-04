package com.yagiz.invoiceservice.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yagiz.commonservice.utils.ModelMapper.ModelMapperService;
import com.yagiz.invoiceservice.business.abstracts.InvoiceService;
import com.yagiz.invoiceservice.business.dtos.responses.get.GetInvoiceListResponse;
import com.yagiz.invoiceservice.business.dtos.responses.get.GetInvoiceResponse;
import com.yagiz.invoiceservice.business.rules.InvoiceBusinessRules;
import com.yagiz.invoiceservice.entity.Invoice;
import com.yagiz.invoiceservice.repository.InvoiceRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class InvoiceManager implements InvoiceService {
    private final InvoiceRepository repository;
    private final ModelMapperService modelMapperService;
    private final InvoiceBusinessRules rules;

    @Override
    public List<GetInvoiceListResponse> getInvoiceList() {
        List<Invoice> invoiceList = repository.findAll();
        List<GetInvoiceListResponse> invoiceResponseList=invoiceList.stream()
        .map(invoice -> modelMapperService.forResponse().map(invoice, GetInvoiceListResponse.class)).toList();

        return invoiceResponseList;
    }

    @Override
    public GetInvoiceResponse getInvoiceById(String id) {
        rules.checkIfInvoiceNotExists(id);
        Invoice invoice = repository.findById(id).orElseThrow();
        GetInvoiceResponse response = modelMapperService.forResponse().map(invoice, GetInvoiceResponse.class);
        return response;
    }

    @Override
    public void add(Invoice invoice) {
        repository.save(invoice);
    } 
}
