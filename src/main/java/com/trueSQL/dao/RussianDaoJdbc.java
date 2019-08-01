package com.trueSQL.dao;

import com.trueSQL.model.EnglishWord;
import com.trueSQL.model.RussianWord;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;

public class RussianDaoJdbc extends EnglishDaoJdbc implements RussianDao {
    @Override
    public Set<RussianWord> findByName(String word) {
        Set<RussianWord> rusWord = new LinkedHashSet<>();
        final String command = "SELECT Eng.English " +
                "FROM `Eng` JOIN `Eng-Ru` ON `Eng`.`idEng` = `Eng-Ru`.`idEng` " +
                "JOIN `Rus` ON `Eng-Ru`.`idRus` = `Rus`.`idRus` " +
                "WHERE Rus.Russians = ?;";

        PreparedStatement preparedStatement;

        try {

            preparedStatement = connection.prepareStatement(command);
            preparedStatement.setString(1, word);
            ResultSet resultSet = preparedStatement.executeQuery();

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
