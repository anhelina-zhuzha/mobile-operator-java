package com.anhelinaZhuzha.mobileOperator.model.discount;


public class NoneDiscount extends Discount {

    public NoneDiscount(String name) {
        super(name);
    }

    @Override
    protected double calculate(double price) {
        return price;
    }

}

