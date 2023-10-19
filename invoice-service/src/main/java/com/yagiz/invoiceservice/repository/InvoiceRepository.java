package com.yagiz.invoiceservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.yagiz.invoiceservice.entity.Invoice;

public interface InvoiceRepository extends MongoRepository<Invoice,String>{
    
}
