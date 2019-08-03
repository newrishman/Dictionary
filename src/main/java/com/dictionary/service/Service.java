package com.dictionary.service;


import java.sql.*;

public class Service {
    private String command;

    private static PreparedStatement preparedStatement;
    private AllSQLCommand allSQLCommand;
    private Connection connection;

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

        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(command);
            preparedStatement.setString(1, word);
            resultSet = preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    public void recordTranslation(String[] inputs, int com) {

        if (com == 1){

        }else {

        }
    }
}
