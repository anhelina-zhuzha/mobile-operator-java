package com.anhelinaZhuzha.mobileOperator.model.storage;

import com.anhelinaZhuzha.mobileOperator.model.Tariff;
import com.anhelinaZhuzha.mobileOperator.model.discount.Discount;
import com.anhelinaZhuzha.mobileOperator.model.discount.FixedPriceDiscount;
import com.anhelinaZhuzha.mobileOperator.model.discount.PercentDiscount;
import com.anhelinaZhuzha.mobileOperator.model.payment.OncePayment;
import com.anhelinaZhuzha.mobileOperator.model.payment.PeriodicalPayment;
import com.anhelinaZhuzha.mobileOperator.model.service.*;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MemoryStorage implements StorageInterface {


    private Map<String, Tariff> services;

    public MemoryStorage() {
        Tariff student = createStudent();
        Tariff aspirant = createAspirant();
        this.services = new HashMap<String, Tariff>();
        this.services.put("student", student);
        this.services.put("aspirant", aspirant);
    }

    @Override
    public Map<String, Tariff> getAll() {
        return services;
    }

    @Override
    public Tariff getByName(String name) {
        Iterator it = services.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if (pair.getKey() == name) {
                return (Tariff) pair.getValue();
            }
        }
        return null;
    }

    private Tariff createStudent() {
        Map<String, Service> services = new HashMap<String, Service>();
        SMS smm = new SMS(
                "SMS",
                true,
                new PeriodicalPayment(5.00, 30),
                200
        );

        MMS mms = new MMS(
                "MMS",
                true,
                new PeriodicalPayment(10.00, 30),
                100
        );

        Internet internet = new Internet(
                "Internet",
                true,
                new PeriodicalPayment(5.00, 30),
                2000
        );

        Dial call = new Dial(
                "Звонки",
                true, new OncePayment(10.00),
                500
        );

        return new Tariff(
                "Жужа Стедент (memory)",
                new ArrayList<Service>(
                        Arrays.asList(
                                smm,
                                mms,
                                call,
                                internet
                        )
                ),
                new FixedPriceDiscount("Черная пятница", 15.0),
                30.0
        );
    }

    private Tariff createAspirant() {
        Map<String, Service> services = new HashMap<String, Service>();
        SMS smm = new SMS(
                "SMS",
                true,
                new PeriodicalPayment(10.00, 30),
                400
        );

        MMS mms = new MMS(
                "MMS",
                true,
                new PeriodicalPayment(15.00, 30),
                200
        );

        Internet internet = new Internet(
                "Internet",
                true,
                new PeriodicalPayment(10.00, 30),
                4000
        );

        Dial call = new Dial(
                "Звонки",
                true, new OncePayment(20.00),
                1000
        );

        return new Tariff(
                "Жужа Анпирант (memory)",
                new ArrayList<Service>(
                        Arrays.asList(
                                smm,
                                mms,
                                call,
                                internet
                        )
                ),
                new FixedPriceDiscount("Черная пятница", 15.0),
                50.0
        );
    }
}
