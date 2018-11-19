package com.anhelinaZhuzha.mobileOperator.model.service;


import com.anhelinaZhuzha.mobileOperator.model.payment.PaymentType;

public class Internet extends Service {


    private int traffic;

    public Internet(String name, boolean isItRequired, PaymentType paymentType, int traffic) {
        super(name, isItRequired, paymentType);
        this.traffic = traffic;
    }

    public int trafficAmount() {
        return traffic;
    }

    @Override
    public String text() {
        return String.format("%d MB internet", traffic) + " / " + super.text();
    }
}

