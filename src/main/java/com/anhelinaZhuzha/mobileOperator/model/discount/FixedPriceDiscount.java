package com.anhelinaZhuzha.mobileOperator.model.discount;


public class FixedPriceDiscount extends Discount {

    private final double fixedDiscountAmount;

    public FixedPriceDiscount(String name, double fixedDiscountAmount) {
        super(name);
        this.fixedDiscountAmount = fixedDiscountAmount;
    }

    @Override
    protected double calculate(double price) {
        return price - fixedDiscountAmount;
    }

}

