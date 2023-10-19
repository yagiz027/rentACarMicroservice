package com.yagiz.invoiceservice.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Invoice {
    @Id
    private String id;
    private String cardHolder;
    private String modelName;
    private String brandName;
    private String plate;
    private int modelYear;
    private double dailyPrice;
    private double totalPrice;
    private int rentedForDays;
    private LocalDateTime rentedAt;
}
