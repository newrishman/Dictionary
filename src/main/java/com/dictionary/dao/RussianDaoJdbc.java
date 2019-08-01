package com.dictionary.dao;

import com.dictionary.service.Service;
import com.dictionary.model.RussianWord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;

public class RussianDaoJdbc extends EnglishDaoJdbc implements RussianDao {
    Connection connection;

    @Override
    public Set<RussianWord> findByName(String word) {
        Service service = new Service();
        connection = service.getConnection();
        Set<RussianWord> rusWord = new LinkedHashSet<>();
        final String command = "SELECT Eng.English " +
                "FROM `Eng` JOIN `Eng-Ru` ON `Eng`.`idEng` = `Eng-Ru`.`idEng` " +
                "JOIN `Rus` ON `Eng-Ru`.`idRus` = `Rus`.`idRus` " +
                "WHERE Rus.Russians = ?;";

        PreparedStatement preparedStatement;
        try {
            ResultSet resultSet = service.resultSet(command, word);

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