package com.anhelinaZhuzha.mobileOperator.model.service;

import com.anhelinaZhuzha.mobileOperator.model.payment.PaymentType;

public abstract class Service {


    protected String name;


    protected boolean isItRequired;


    protected PaymentType paymentType;


    public Service(String name, boolean isItRequired, PaymentType paymentType) {
        super();

        this.name = name;
        this.isItRequired = isItRequired;
        this.paymentType = paymentType;
    }


    public String name() {
        return name;
    }


    public boolean isRequired() {
        return isItRequired;
    }


    public PaymentType paymentType() {
        return paymentType;
    }

    public double price() {
        return paymentType.price();
    }

    public String text() {
        return String.format("%s", paymentType.name());
    }
}

