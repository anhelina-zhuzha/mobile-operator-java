package com.anhelinaZhuzha.mobileOperator.model.payment;


public abstract class PaymentType {

    protected String name;

    public PaymentType() {
        super();
    }

    public abstract double price();

    public String name() {
        return name;
    }
}

