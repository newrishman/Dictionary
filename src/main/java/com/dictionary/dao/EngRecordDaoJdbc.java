package com.dictionary.dao;

import com.dictionary.service.Service;

import java.sql.Connection;

public class EngRecordDaoJdbc implements EngRecordDao {
    private String word;
    private Long engId;
    private Long rusId;
    private Connection connection;
    private Service service;

    @Override
    public void record(String[] inputs) {
        service = new Service();
        connection = service.getConnection();

        word = inputs[2];
        // команда #5 - поиск английского id
        engId = service.searchId(5, word);
        if (engId == null) {
            // команда #7 - запись английского слова
            engId = service.recordWord(7, word);
        }

        for (int x = 3; x < inputs.length; x++) {

            service = new Service();
            connection = service.getConnection();

            word = inputs[x];
            // команда #6 - поиск русского id
            rusId = service.searchId(6, word);
            if (rusId == null) {
                // команда #8 - запись русского слова
                rusId = service.recordWord(8, word);

            }
            // команда #9 - запись русского и английского ID
            service.recordId(9, engId, rusId);

        }
    }
}

