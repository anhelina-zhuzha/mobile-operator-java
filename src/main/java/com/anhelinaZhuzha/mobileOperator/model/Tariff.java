package com.anhelinaZhuzha.mobileOperator.model;

import com.anhelinaZhuzha.mobileOperator.model.discount.Discount;
import com.anhelinaZhuzha.mobileOperator.model.service.Service;

import java.util.ArrayList;


public class Tariff {


    private String name;


    private ArrayList<Service> services;


    private Discount discount;

    private double price;

    public Tariff(String name, ArrayList<Service> services, Discount discount, double price) {
        this.name = name;
        this.services = services;
        this.discount = discount;
        this.price = price;
    }

    public String name() {
        return name;
    }

    public ArrayList<Service> includedServices() {
        return services;
    }

    public Discount discount() {
        return discount;
    }

    public double finalPrice() {
        return discount.getPriceAfterDiscount(this.price());
    }

    public double price() {

        double servicesPrice = 0;
        for (Service service:
              services) {
            servicesPrice += service.price();
        }
        return price + servicesPrice;
    }

    public String servicesInfo() {
        String info = "";

        for (Service service:
                services) {
            info +=  " - " + service.text() + "\n";
        }
        return  info;
    }

    public boolean hasService(String name) {
        for (Service service:
                services) {
            if (service.name().equals(name)) {
                return true;
            }
        }

        return false;
    }
}

