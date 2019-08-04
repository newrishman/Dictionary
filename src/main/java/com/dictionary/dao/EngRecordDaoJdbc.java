package com.dictionary.dao;

import com.dictionary.service.Service;

import java.sql.Connection;

public class EngRecordDaoJdbc implements EngRecordDao {
    private Connection connection;
    Service service;

    @Override
    public void record(String[] inputs) {
        service = new Service();
        connection = service.getConnection();
        Service service = new Service();
        service.recordTranslation(inputs);
    }
}
