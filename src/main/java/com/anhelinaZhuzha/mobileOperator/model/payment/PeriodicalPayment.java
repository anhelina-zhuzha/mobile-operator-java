package com.anhelinaZhuzha.mobileOperator.model.payment;

import java.util.Date;


public class PeriodicalPayment extends PaymentType {


    private double price;


    private int periodDays;


    public PeriodicalPayment(double price, int periodDays) {
        super();
        this.price = price;
        this.periodDays = periodDays;
    }

    @Override
    public double price() {
        return price;
    }

    @Override
    public String name() {
        return String.format("за %d дней", periodDays);
    }


    public int period() {
        return periodDays;
    }

}

