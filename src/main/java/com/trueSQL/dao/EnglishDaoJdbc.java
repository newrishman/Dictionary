package com.trueSQL.dao;

import com.trueSQL.service.Service;
import com.trueSQL.model.EnglishWord;

import java.sql.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class EnglishDaoJdbc implements EnglishDao {
    Connection connection;


    @Override
    public Set<?> findByName(String word) {
        Service service = new Service();
        connection = service.getConnection();
        Set<EnglishWord> engWord = new LinkedHashSet<>();
        final String command = "SELECT Rus.Russians " +
                "FROM `Eng` JOIN `Eng-Ru` ON `Eng`.`idEng` = `Eng-Ru`.`idEng` " +
                "JOIN `Rus` ON `Eng-Ru`.`idRus` = `Rus`.`idRus` " +
                "WHERE Eng.English = ?;";

        PreparedStatement preparedStatement;
        try {
            ResultSet resultSet = service.resultSet(command, word);

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
