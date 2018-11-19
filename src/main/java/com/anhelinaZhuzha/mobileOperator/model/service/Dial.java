package com.anhelinaZhuzha.mobileOperator.model.service;

import com.anhelinaZhuzha.mobileOperator.model.payment.PaymentType;

public class Dial extends Service {


    private int minutes;


    public Dial(String name, boolean isItRequired, PaymentType paymentType, int minutes) {
        super(name, isItRequired, paymentType);
        this.minutes = minutes;
    }

    public int minutesAmount() {
        return minutes;
    }

    @Override
    public String text() {
        return String.format("%d минут звонков", minutes) + " / " + super.text();
    }
}

