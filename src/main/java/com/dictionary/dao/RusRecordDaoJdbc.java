package com.dictionary.dao;

import com.dictionary.service.Service;

public class RusRecordDaoJdbc implements RusRecordDao {
    @Override
    public void record(String[] inputs) {
        Service service = new Service();
        service.recordTranslation(inputs, 2);
    }
}
