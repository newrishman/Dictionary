package com.dictionary.service;


import java.sql.*;

public class Service {
    private String command;
    private Long id;

    private AllSQLCommand allSQLCommand;
    private Connection connection;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;

    public Connection getConnection() {

        final String URL = "jdbc:mysql://localhost:3306/Dictionary?useSSL=false&serverTimezone=UTC";
        final String username = "root";
        final String password = "qweqweqwe";

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

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }
    }

    public ResultSet resultSet(int com, String word) {
        allSQLCommand = new AllSQLCommand();
        command = allSQLCommand.getCommand(com);

        if (com == 2 || com == 4) {
            word = word + "%";
        }

        try {
            preparedStatement = connection.prepareStatement(command);
            preparedStatement.setString(1, word);
            resultSet = preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    public long searchId(int com, String word) {

        allSQLCommand = new AllSQLCommand();
        command = allSQLCommand.getCommand(com);

        // команда 5 - поиск английского слова
        // команда 6 - поиск русского слова
        try {
            preparedStatement = connection.prepareStatement(command);
            preparedStatement.setString(1, word);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getLong(1);
            }
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public long recordWord(int com, String word) {
        allSQLCommand = new AllSQLCommand();
        command = allSQLCommand.getCommand(com);

        try {
            preparedStatement = connection.prepareStatement(command, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, word);
            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            id = generatedKeys.getLong(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public void recordId(int com, long engId, long rusId) {

        command = allSQLCommand.getCommand(com);

        try {
            preparedStatement = connection.prepareStatement(command);
            preparedStatement.setLong(1, engId);
            preparedStatement.setLong(2, rusId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Запись не прошла");
            e.printStackTrace();
        }
    }
}
