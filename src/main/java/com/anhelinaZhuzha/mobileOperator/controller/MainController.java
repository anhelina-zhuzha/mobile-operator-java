package com.anhelinaZhuzha.mobileOperator.controller;


import com.anhelinaZhuzha.mobileOperator.model.Tariff;
import com.anhelinaZhuzha.mobileOperator.model.storage.FileStorage;
import com.anhelinaZhuzha.mobileOperator.model.storage.StorageInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class MainController {


    // inject via application.properties
    @Value("${base.message:test}")
    private String message = "Hello World";

    @RequestMapping("/")
    public String welcome(Map<String, Object> model, @RequestParam("service") Optional<List<String>> services) {
        model.put("message", this.message);

        StorageInterface storage = new FileStorage();

        Map<String, Tariff> tariffs = storage.getAll();
        List<Tariff> filtered = new ArrayList<Tariff>();

        for (Tariff tariff: tariffs.values()) {
            boolean isOk = true;
            if (services.isPresent()) {
                for (String service : services.get()) {
                    if (!tariff.hasService(service)) {
                        isOk = false;
                        break;
                    }
                }
            }

            if (isOk) {
                filtered.add(tariff);
            }
        }

        model.put("tariffs", filtered);

        model.put("services", services.isPresent() ? services.get() : new ArrayList<String>());

        return "base";
    }
}
