package com.anhelinaZhuzha.mobileOperator.model.discount;


public class FixedPriceDiscount extends Discount {

    private final double fixedDiscountAmount;

    public FixedPriceDiscount(String name, double fixedDiscountAmount) {
        super(name);
        this.fixedDiscountAmount = fixedDiscountAmount;
    }

    /**
     * Dynamic polymorphism, method overridden method on the super class
     */
    @Override
    protected double calculate(double price) {
        return price - fixedDiscountAmount;
    }

}

