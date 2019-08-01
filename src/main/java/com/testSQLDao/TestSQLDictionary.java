package com.testSQLDao;

import java.sql.*;

public class TestSQLDictionary {

    private static String URL = "jdbc:mysql://localhost:3306/Dictionary?useSSL=false&serverTimezone=UTC";
    private static String username = "root";
    private static String password = "qweqweqwe";

    public static void main(String[] args) {

        // * * * * Тут можно вставить любое слово * * * *  //
        String word = "hi";

        Connection connection;

        try {
            connection = DriverManager.getConnection(URL, username, password);

            Statement statement = connection.createStatement();

            // * * * * SQL команда для поиска перевода с русского  * * * *  //
            String command = "select  Eng.English\n" +
                    "from `Eng` \n" +
                    "join `Eng-Ru` on `Eng`.`idEng` = `Eng-Ru`.`idEng`\n" +
                    "join `Rus` on `Eng-Ru`.`idRus` = `Rus`.`idRus`\n" +
                    "where `Rus`.`Russians` = '" + word + "';";

            ResultSet resultSet = statement.executeQuery(command);

            String result = null;

            while (resultSet.next()) {
                result = resultSet.getString(1);
                System.out.println(result);
            }
            // * * * * если искомого слова среди русских нет * * * *  //
            if (result == null) {

                // * * * * SQL команда для поиска перевода с английского  * * * *  //
                command = "select  Rus.Russians\n" +
                        "from `Eng` \n" +
                        "join `Eng-Ru` on `Eng`.`idEng` = `Eng-Ru`.`idEng`\n" +
                        "join `Rus` on `Eng-Ru`.`idRus` = `Rus`.`idRus`\n" +
                        "where Eng.English = '" + word + "';";

                resultSet = statement.executeQuery(command);

                String result2 = null;
                while (resultSet.next()) {
                    result2 = resultSet.getString(1);
                    System.out.println(result2);
                }

                // * * * * если искомого слова нет и среди ангийских, то... * * * *  //
                if (result2 == null) {
                    System.out.println("такого слова нет!!!!");

                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
