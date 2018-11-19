package com.anhelinaZhuzha.mobileOperator.model.service;


import com.anhelinaZhuzha.mobileOperator.model.payment.PaymentType;

public class MMS extends SMS {

    public MMS(String name, boolean isItRequired, PaymentType paymentType, int amount) {
        super(name, isItRequired, paymentType, amount);
    }

    @Override
    public String text() {
        return super.text().replace("смс", "ммс");
    }
}

