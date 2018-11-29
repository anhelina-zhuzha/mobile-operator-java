package com.anhelinaZhuzha.mobileOperator.model.discount;


public class PercentDiscount extends Discount {

    private double discountInPercent;

    public PercentDiscount(String name, double discountInPercent) {
        super(name);
        this.discountInPercent = discountInPercent;
    }

    @Override
    protected double calculate(double price) {
        return price - price * discountInPercent;
    }


}

