package com.anhelinaZhuzha.mobileOperator.model.payment;


public abstract class PaymentType {


    public PaymentType() {
        super();
    }

    public abstract double price();

    public abstract String name();
}

