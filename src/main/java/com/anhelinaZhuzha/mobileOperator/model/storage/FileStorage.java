package com.anhelinaZhuzha.mobileOperator.model.storage;

import com.anhelinaZhuzha.mobileOperator.model.Tariff;
import com.anhelinaZhuzha.mobileOperator.model.discount.Discount;
import com.anhelinaZhuzha.mobileOperator.model.discount.FixedPriceDiscount;
import com.anhelinaZhuzha.mobileOperator.model.discount.PercentDiscount;
import com.anhelinaZhuzha.mobileOperator.model.payment.PeriodicalPayment;
import com.anhelinaZhuzha.mobileOperator.model.service.*;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileStorage implements StorageInterface {


    @Override
    public Map<String, Tariff> getAll() {
        HashMap<String, Tariff> services = new HashMap<>();
        for (String name: listFilesForFolder()) {
            String realName = name.replace(".json", "");
            services.put(realName, getByName(realName));
        }
        return services;
    }

    @Override
    public Tariff getByName(String name) {
        try {
            String data = readStream("src/main/resources/data/" + name + ".json");
            Map targetObject = new Gson().fromJson(data, Map.class);
            return buildModel(targetObject);
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
        return null;
    }

    private List<String> listFilesForFolder() {
        File folder = new File("src/main/resources/data/");
        List files = new ArrayList();
        for (final File fileEntry : folder.listFiles()) {
            files.add(fileEntry.getName());
        }
        return files;
    }

    private Tariff buildModel(Map targetObject) {
        String name = targetObject.get("name").toString();

        // create Discount
        Discount discount = createDscount((Map) targetObject.get("discount"));
        // create Services
        ArrayList<Service> services = createServices((ArrayList<Map>) targetObject.get("services"));

        Double price = Double.parseDouble(
                targetObject.get("price").toString()
        );
        return new Tariff(
                name,
                services,
                discount,
                price
        );
    }

    private ArrayList<Service> createServices(List<Map> services) {
        ArrayList objects = new ArrayList<Service>();
        for (Map service : services
        ) {
            objects.add(createService(service));

        }
        return objects;
    }

    private Service createService(Map service) {
        switch (service.get("type").toString()) {
            case "dial":
                int dialPrice = (int) Double.parseDouble(((Map)service.get("paymentType")).get("periodDays").toString());
                return new Dial(
                        service.get("name").toString(),
                        Boolean.valueOf(service.get("isItRequired").toString()),
                        new PeriodicalPayment(
                                (double) ((Map)service.get("paymentType")).get("price"),
                                dialPrice
                        ),
                        (int) Double.parseDouble(
                                service.get("minutes").toString()
                        )
                );
            case "sms":
                int smsPrice = (int) Double.parseDouble(((Map)service.get("paymentType")).get("periodDays").toString());
                return new SMS(
                        service.get("name").toString(),
                        Boolean.valueOf(service.get("isItRequired").toString()),
                        new PeriodicalPayment(
                                (double) ((Map)service.get("paymentType")).get("price"),
                                smsPrice
                        ),
                        (int) Double.parseDouble(
                                service.get("amount").toString()
                        )
                );
            case "mms":
                int mmsPrice = (int) Double.parseDouble(((Map)service.get("paymentType")).get("periodDays").toString());
                return new MMS(
                        service.get("name").toString(),
                        Boolean.valueOf(service.get("isItRequired").toString()),
                        new PeriodicalPayment(
                                (double) ((Map)service.get("paymentType")).get("price"),
                                mmsPrice
                        ),
                        (int) Double.parseDouble(
                                service.get("amount").toString()
                        )
                );
            case "internet":
                int internetPrice = (int) Double.parseDouble(((Map)service.get("paymentType")).get("periodDays").toString());

                return new Internet(
                        service.get("name").toString(),
                        Boolean.valueOf(service.get("isItRequired").toString()),
                        new PeriodicalPayment(
                                (double) ((Map)service.get("paymentType")).get("price"),
                                internetPrice
                        ),
                        (int) Double.parseDouble(
                                service.get("traffic").toString()
                        )
                );
        }
        return null;
    }

    private Discount createDscount(Map discount) {
        switch (discount.get("type").toString()) {
            case "fixed":
                return new FixedPriceDiscount(
                        discount.get("name").toString(),
                        Double.parseDouble(
                                discount.get("fixedDiscountAmount").toString()
                        )
                );
            case "percent":
                return new PercentDiscount(
                        discount.get("name").toString(),
                        Double.parseDouble(
                                discount.get("discountInPercent").toString()
                        )
                );
        }
        return null;
    }

    private static String readStream(String filename) throws FileNotFoundException {
        return new Scanner(new File(filename)).useDelimiter("\\A").next();
    }
}
