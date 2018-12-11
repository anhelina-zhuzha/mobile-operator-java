package com.anhelinaZhuzha.mobileOperator.model.storage;

public class MemoryStorageFactory implements StorageFactoryInterface {

    public StorageInterface createStorage() {
        return new MemoryStorage();
    }
}
