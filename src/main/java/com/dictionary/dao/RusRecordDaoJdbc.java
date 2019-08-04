package com.dictionary.dao;

import com.dictionary.service.Service;

import java.sql.Connection;

public class RusRecordDaoJdbc implements RusRecordDao {
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
