package com.dictionary.dao;

import com.dictionary.service.Service;

public class EngRecordDaoJdbc implements EngRecordDao {
    @Override
    public void record(String[] inputs) {
        Service service = new Service();
        service.recordTranslation(inputs, 1);
    }
}
