package com.anhelinaZhuzha.mobileOperator;

import com.anhelinaZhuzha.mobileOperator.model.Tariff;

import com.anhelinaZhuzha.mobileOperator.model.storage.FileStorage;
import com.anhelinaZhuzha.mobileOperator.model.storage.StorageInterface;

import java.util.Iterator;
import java.util.Map;

public class MobileOperatorApplication {

    public static void main(String[] args) {
        StorageInterface storage = new FileStorage();

        Tariff student = storage.getByName("student");

        System.out.println("Tariff: " + student.name());
        System.out.println("Price: " + student.finalPrice());
        System.out.println("Services: \n" + student.servicesInfo());


        Map<String, Tariff> tariffs = storage.getAll();
        Iterator it = tariffs.entrySet().iterator();
        while (it.hasNext()) {

            Map.Entry pair = (Map.Entry)it.next();
            Tariff tariff = (Tariff) pair.getValue();
            System.out.println("Tariff: " + tariff.name());
            System.out.println("Price: " + tariff.finalPrice());
            System.out.println("Services: \n" + tariff.servicesInfo());
            System.out.println("\n");
        }
    }
}