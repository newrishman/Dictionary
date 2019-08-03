package com.dictionary.service;


import java.sql.*;

public class Service {
    private static final String URL = "jdbc:mysql://localhost:3306/Dictionary?useSSL=false&serverTimezone=UTC";
    private static final String username = "root";
    private static final String password = "qweqweqwe";
    private static PreparedStatement preparedStatement;

    private Connection connection;

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

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }
    }

    public ResultSet resultSet(int com, String word) {

        String command;
        final String enCommand = "SELECT Rus.Russians " +
                "FROM `Eng` JOIN `Eng-Ru` ON `Eng`.`idEng` = `Eng-Ru`.`idEng` " +
                "JOIN `Rus` ON `Eng-Ru`.`idRus` = `Rus`.`idRus` " +
                "WHERE Eng.English =  ?;";

        final String ruCommand = "SELECT Eng.English " +
                "FROM `Eng` JOIN `Eng-Ru` ON `Eng`.`idEng` = `Eng-Ru`.`idEng` " +
                "JOIN `Rus` ON `Eng-Ru`.`idRus` = `Rus`.`idRus` " +
                "WHERE Rus.Russians =  ?;";

        final String enCommand2 = "select English from Eng where English like ? order by\n" +
                " char_length(English), English asc;";

        final String ruCommand2 = "select Russians from Rus where Russians like ? order by \n" +
                " char_length(Russians), Russians asc;";

        if (com == 1) {
            command = enCommand;
        } else if (com == 2) {
            command = ruCommand;
        } else if (com == 3) {
            command = enCommand2;
            word = word + "%";
        } else {
            command = ruCommand2;
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

    public void recordTranslation (String[] inputs, int com){



    }
}
