package com.newrishman.dao;

import com.newrishman.model.Dictionary;

import java.sql.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class JDBCDictionaryDAO implements DictionaryDAO {

    private static String URL = "jdbc:mysql://localhost:3306/Dictionary?useSSL=false&serverTimezone=UTC";
    private static String username = "root";
    private static String password = "qweqweqwe";

    Connection connection;

    @Override
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


    @Override
    public Set<String> select() {

        PreparedStatement preparedStatement;
        Dictionary dictionary = new Dictionary();
        Set<String> translation = new LinkedHashSet<>();
        String word = dictionary.word();
        try {

            preparedStatement = connection.prepareStatement(dictionary.command());
            preparedStatement.setString(1, word);
            preparedStatement.setString(2, word);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                translation.add(resultSet.getString(1));
            }
            if (translation.isEmpty()){
                System.out.println("Dictionary didn't know this word ");
            } else {
                System.out.println(translation);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return translation;
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
