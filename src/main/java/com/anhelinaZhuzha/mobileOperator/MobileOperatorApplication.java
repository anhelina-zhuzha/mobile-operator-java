package com.anhelinaZhuzha.mobileOperator;

import com.anhelinaZhuzha.mobileOperator.model.Tariff;
import com.anhelinaZhuzha.mobileOperator.model.discount.FixedPriceDiscount;
import com.anhelinaZhuzha.mobileOperator.model.payment.OncePayment;
import com.anhelinaZhuzha.mobileOperator.model.payment.PeriodicalPayment;
import com.anhelinaZhuzha.mobileOperator.model.service.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MobileOperatorApplication {

    public static void main(String[] args) {

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

        Tariff student = new Tariff(
                "Жужа Стедент",
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

        System.out.println("Tariff: " + student.name());
        System.out.println("Price: " + student.finalPrice());
        System.out.println("Services: \n" + student.servicesInfo());
    }
}