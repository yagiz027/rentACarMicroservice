package com.yagiz.commonservice.utils.RestExceptionHandler.constants;

public class Messages {
    public static class Car{
        public static final String NotExists="CAR_NOT_EXIST";
        public static final String AlreadyExists="CAR_ALREADY_EXISTS";
        public static final String NotAvailable="CAR_NOT_AVAILABLE";
    }
    
    
    public static class Brand{
        public static final String NotExists="BRAND_NOT_EXIST";
        public static final String AlreadyExists="BRAND_ALREADY_EXISTS";
        public static final String NotAvailable="BRAND_NOT_AVAILABLE";
    }
    
    public static class Model{
        public static final String NotExists="MODEL_NOT_EXIST";
        public static final String AlreadyExists="MODEL_ALREADY_EXISTS";
        public static final String NotAvailable="MODEL_NOT_AVAILABLE";
    }
    
    public static class Inventory{
        public static final String ServiceNotAvailable="INVENTORY_SERVICE_NOT_AVAILABLE";
    }

    public static class Maintenance{
        public static final String NotExists="MAINTENANCE_NOT_EXISTS";
        public static final String ServiceNotAvailable="MAINTENANCE_SERVICE_NOT_AVAILABLE";
    }

    public static class Invoice{
        public static final String NotExists="INVOICE_NOT_EXISTS";
        public static final String ServiceNotAvailable="INVOICE_SERVICE_NOT_AVAILABLE";
    }

    public static class Rental{
        public static final String NotExists="RENTAL_NOT_EXISTS";
        public static final String ServiceNotAvailable="RENTAL_SERVICE_NOT_AVAILABLE";
    }

    public static class Payment{
        public static final String NotExists="PAYMENT_NOT_EXISTS";
        public static final String ExpirationDateExpired="PAYMENT_EXPIRATION_DATE_EXPIRED";
        public static final String NotEnoughMoney="NOT_ENOUGH_MONEY";
        public static final String AlreadyExists="PAYMENT_ALREADY_EXISTS";
        public static final String PaymentIsFailed="PAYMENT_NOT_SUCESSFULL";
        public static final String PaymentIsNotValid = "PAYMENT_NOT_VALID";
        public static final String ServiceNotAvailable = "PAYMENT_SERVICE_NOT_AVAILABLE";
    }
}
