package com.anhelinaZhuzha.mobileOperator.model.storage;

public class FileStorageFactory implements StorageFactoryInterface {

    public StorageInterface createStorage() {
        return new FileStorage();
    }
}
