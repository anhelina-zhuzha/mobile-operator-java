package com.anhelinaZhuzha.mobileOperator.model.discount;


public class PrecentDiscount extends Discount {

    private double discountInPercent;

    public PrecentDiscount(String name, double discountInPercent) {
        super(name);
        this.discountInPercent = discountInPercent;
    }

    @Override
    protected double calculate(double price) {
        return price - price * discountInPercent;
    }


}

