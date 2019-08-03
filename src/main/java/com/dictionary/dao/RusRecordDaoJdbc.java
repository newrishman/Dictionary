package com.dictionary.dao;

import com.dictionary.service.Service;

import java.sql.Connection;

public class RusRecordDaoJdbc implements RusRecordDao {
    Connection connection;
    Service service = new Service();

    @Override
    public void record(String[] inputs) {
        connection = service.getConnection();
        Service service = new Service();
        service.recordTranslation(inputs, 2);
    }
}
