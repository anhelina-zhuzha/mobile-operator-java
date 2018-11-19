package com.anhelinaZhuzha.mobileOperator.model.service;


import com.anhelinaZhuzha.mobileOperator.model.payment.PaymentType;

public class SMS extends Service {


    protected int amount;

    public SMS(String name, boolean isItRequired, PaymentType paymentType, int amount) {
        super(name, isItRequired, paymentType);
        this.amount = amount;
    }

    public int messagesAmount() {
        return amount;
    }

    @Override
    public String text() {
        return String.format("%d смс", amount) + " / " + super.text();
    }
}

