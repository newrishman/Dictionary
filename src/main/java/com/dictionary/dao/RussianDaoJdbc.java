package com.dictionary.dao;

import com.dictionary.service.Service;
import com.dictionary.model.RussianWord;

import java.sql.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class RussianDaoJdbc extends EnglishDaoJdbc implements RussianDao {
    private Connection connection;

    @Override
    public Set<RussianWord> findByName(int com, String word) {
        Service service = new Service();
        connection = service.getConnection();
        Set<RussianWord> rusWord = new LinkedHashSet<>();

        try {
            ResultSet resultSet = service.resultSet(com, word);

            RussianWord russianWord;
            while (resultSet.next()) {
                russianWord = new RussianWord();
                russianWord.setName(resultSet.getString(1));
                rusWord.add(russianWord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rusWord;
    }
}
