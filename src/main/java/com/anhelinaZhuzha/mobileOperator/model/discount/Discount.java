package com.anhelinaZhuzha.mobileOperator.model.discount;

abstract public class Discount {

    private String name;

    public Discount(String name) {
        super();
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public double getPriceAfterDiscount(double price) {

        return calculate(price);
    }


    protected double calculate(double price) {
        return price;
    }

}

