package com.dictionary.service;


import java.sql.*;

public class Service {
    private String command;
    private String words;
    private long idEng;
    private long idRus;

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

        if (com == 3 || com == 4) {
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

    public void recordTranslation(@org.jetbrains.annotations.NotNull String[] inputs) {
        getConnection();
        allSQLCommand = new AllSQLCommand();

        words = inputs[2];
        command = allSQLCommand.getCommand(5);
        try {
            preparedStatement = connection.prepareStatement(command, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, words);
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            idEng = generatedKeys.getLong(1);

            for (int x = 3; x < inputs.length; x++) {
                words = inputs[x];
                command = allSQLCommand.getCommand(6);
                preparedStatement = connection.prepareStatement(command, PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, words);
                preparedStatement.executeUpdate();
                generatedKeys = preparedStatement.getGeneratedKeys();
                generatedKeys.next();
                idRus = generatedKeys.getLong(1);

                command = allSQLCommand.getCommand(7);
                preparedStatement = connection.prepareStatement(command);
                preparedStatement.setLong(1, idEng);
                preparedStatement.setLong(2, idRus);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
