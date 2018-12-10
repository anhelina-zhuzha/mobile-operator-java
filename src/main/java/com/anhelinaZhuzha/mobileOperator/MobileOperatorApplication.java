package com.anhelinaZhuzha.mobileOperator;

import com.anhelinaZhuzha.mobileOperator.model.Tariff;

import com.anhelinaZhuzha.mobileOperator.model.storage.*;

import java.util.Iterator;
import java.util.Map;

public class MobileOperatorApplication {

    public static void main(String[] args) throws Exception {

        String storageName;
        if (args.length > 0){
            storageName = args[0];
        } else {
            storageName = "file";
        }

        StorageFactoryInterface storageFactory;
        switch (storageName) {
            case "file":
                storageFactory = new FileStorageFactory();
                break;
            case "memory":
                storageFactory = new MemoryStorageFactory();
                break;
            default:
                throw new Exception("Can't find storage");
        }

        StorageInterface storage = storageFactory.createStorage();
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