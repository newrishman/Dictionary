package com.testSQLDao.model;

import java.util.Scanner;

//  я хз, что можно было засунуть в модель, у меня достаточно простой код ¯\_(ツ)_/¯
public class Dictionary {

    public String word() {
        Scanner input = new Scanner(System.in);
        String word = input.nextLine();
        return word;
    }

    public String command() {
        String command =
                "(SELECT \n" +
                        "    Rus.Russians\n" +
                        "FROM\n" +
                        "    `Eng`\n" +
                        "        JOIN\n" +
                        "    `Eng-Ru` ON `Eng`.`idEng` = `Eng-Ru`.`idEng`\n" +
                        "        JOIN\n" +
                        "    `Rus` ON `Eng-Ru`.`idRus` = `Rus`.`idRus`\n" +
                        "WHERE\n" +
                        "    Eng.English = ?) UNION ALL (SELECT \n" +
                        "    Eng.English\n" +
                        "FROM\n" +
                        "    `Eng`\n" +
                        "        JOIN\n" +
                        "    `Eng-Ru` ON `Eng`.`idEng` = `Eng-Ru`.`idEng`\n" +
                        "        JOIN\n" +
                        "    `Rus` ON `Eng-Ru`.`idRus` = `Rus`.`idRus`\n" +
                        "WHERE\n" +
                        "    Rus.Russians = ?);";
        return command;
    }
}
