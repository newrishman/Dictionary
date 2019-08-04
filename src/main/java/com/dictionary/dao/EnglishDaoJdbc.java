package com.dictionary.dao;

import com.dictionary.service.Service;
import com.dictionary.model.EnglishWord;

import java.sql.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class EnglishDaoJdbc implements EnglishDao {
    private Connection connection;

    @Override
    public Set<?> findByName(int com, String word) {
        Service service = new Service();
        connection = service.getConnection();
        Set<EnglishWord> engWord = new LinkedHashSet<>();

        try {
            ResultSet resultSet = service.resultSet(com, word);

            EnglishWord englishWord;
            while (resultSet.next()) {
                englishWord = new EnglishWord();
                englishWord.setName(resultSet.getString(1));
                engWord.add(englishWord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return engWord;
    }


}
