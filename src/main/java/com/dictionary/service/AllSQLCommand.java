package com.dictionary.service;

public class AllSQLCommand {

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


    private String command;

    public String getCommand(int number) {
        if (number == 1) {
            command =enCommand;
        } else if (number == 2) {
            command =ruCommand;
        } else if (number == 3) {
            command =enCommand2;
        } else /*if (number == 4)*/ {
            command =ruCommand2;
        /*} else if (number == 5) {
            command =;
        } else if (number == 6) {
            command =;
        } else if (number == 7) {
            command =;
        } else if (number == 8) {
            command =;
        } else if (number == 9) {
            command =;
        } else if (number == 10) {
            command =;*/
        }
        return command;
    }
}
