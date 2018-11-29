package com.anhelinaZhuzha.mobileOperator.model.storage;

import com.anhelinaZhuzha.mobileOperator.model.Tariff;

import java.util.Map;

public interface StorageInterface {
    public Map<String, Tariff> getAll();

    public Tariff getByName(String name);
}
