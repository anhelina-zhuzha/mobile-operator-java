package com.anhelinaZhuzha.mobileOperator.model.payment;


public class OncePayment extends PaymentType {


    private double price;


    public OncePayment(double price) {
        super();

        this.price = price;
    }

    @Override
    public double price() {
        return price;
    }

    @Override
    public String name() {
        return "единоразово";
    }

}

