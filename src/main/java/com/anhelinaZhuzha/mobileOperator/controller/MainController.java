package com.anhelinaZhuzha.mobileOperator.controller;


import com.anhelinaZhuzha.mobileOperator.model.Tariff;
import com.anhelinaZhuzha.mobileOperator.model.storage.FileStorage;
import com.anhelinaZhuzha.mobileOperator.model.storage.StorageInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class MainController {


    // inject via application.properties
    @Value("${base.message:test}")
    private String message = "Hello World";

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);

        StorageInterface storage = new FileStorage();

        Map<String, Tariff> tariffs = storage.getAll();

        model.put("tariffs", tariffs.values());

        return "base";
    }
}
