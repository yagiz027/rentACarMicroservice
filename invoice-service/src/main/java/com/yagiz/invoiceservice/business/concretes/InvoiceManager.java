package com.yagiz.invoiceservice.business.concretes;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.yagiz.commonservice.utils.Kafka.KafkaProducer;
import com.yagiz.commonservice.utils.ModelMapper.ModelMapperService;
import com.yagiz.commonservice.utils.RestExceptionHandler.constants.Messages;
import com.yagiz.commonservice.utils.RestExceptionHandler.exceptions.BusinessException;
import com.yagiz.invoiceservice.business.abstracts.InvoiceService;
import com.yagiz.invoiceservice.business.dtos.requests.CreateInvoiceRequest;
import com.yagiz.invoiceservice.business.dtos.requests.UpdateInvoiceRequest;
import com.yagiz.invoiceservice.business.dtos.responses.CreateInvoiceResponse;
import com.yagiz.invoiceservice.business.dtos.responses.UpdateInvoiceResponse;
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
    private final KafkaProducer producer;

    @Override
    public CreateInvoiceResponse add(CreateInvoiceRequest createInvoiceRequest) {
       Invoice invoice=modelMapperService.forRequest().map(createInvoiceRequest, Invoice.class);
       invoice.setRentedAt(LocalDateTime.now());
       invoice.setId(0);
       repository.save(invoice);
       CreateInvoiceResponse response = modelMapperService.forResponse().map(invoice, CreateInvoiceResponse.class);
       //TODO: Kafka invoice create event
       return response;
    }

    @Override
    public UpdateInvoiceResponse update(int id, UpdateInvoiceRequest updateInvoiceRequest) {
        Invoice invoice = modelMapperService.forRequest().map(updateInvoiceRequest, Invoice.class);
        invoice.setId(id);
        invoice.setRentedAt(LocalDateTime.now());
        repository.save(invoice);
        UpdateInvoiceResponse response = modelMapperService.forResponse().map(invoice, UpdateInvoiceResponse.class);
        return response;
    }

    @Override
    public List<GetInvoiceListResponse> getInvoiceList() {
        List<Invoice> invoiceList = repository.findAll();
        List<GetInvoiceListResponse> invoiceResponseList=invoiceList.stream()
        .map(invoice -> modelMapperService.forResponse().map(invoice, GetInvoiceListResponse.class)).toList();

        return invoiceResponseList;
    }

    @Override
    public GetInvoiceResponse getInvoiceById(int id) {
        Invoice invoice = repository.findById(id).orElseThrow(()-> new BusinessException(Messages.Invoice.NotExists));
        GetInvoiceResponse response = modelMapperService.forResponse().map(invoice, GetInvoiceResponse.class);
        return response;
    }

    @Override
    public void deleteById(int id) {
        rules.checkIfInvoiceNotExists(id);
        repository.deleteById(id);
        //TODO : Invoice deleted kafka event 
    }    
}
