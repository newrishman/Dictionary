package com.trueSQL.dao;

import com.trueSQL.model.EnglishWord;

import java.sql.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class EnglishDaoJdbc implements EnglishDao {

    private static final String URL = "jdbc:mysql://localhost:3306/Dictionary?useSSL=false&serverTimezone=UTC";
    private static final String username = "root";
    private static final String password = "qweqweqwe";


    @Override
    public Set<?> findByName(String word) {
        Set<EnglishWord> engWord = new LinkedHashSet<>();
        final String command = "SELECT Rus.Russians " +
                "FROM `Eng` JOIN `Eng-Ru` ON `Eng`.`idEng` = `Eng-Ru`.`idEng` " +
                "JOIN `Rus` ON `Eng-Ru`.`idRus` = `Rus`.`idRus` " +
                "WHERE Eng.English = ?;";

        PreparedStatement preparedStatement;
        try {

            preparedStatement = connection.prepareStatement(command);
            preparedStatement.setString(1, word);
            ResultSet resultSet = preparedStatement.executeQuery();

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


    Connection connection;

    public Connection getConnection() {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(URL, username, password);
            }
        } catch (SQLException e) {
            System.err.println("Driver not run!");
            System.err.println(e);
        }
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
        }
    }

}
