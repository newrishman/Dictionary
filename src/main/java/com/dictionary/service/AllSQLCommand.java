package com.dictionary.service;

public class AllSQLCommand {

    private final String SearchEn = "SELECT Rus.Russians " +
            "FROM `Eng` JOIN `Eng-Ru` ON `Eng`.`idEng` = `Eng-Ru`.`idEng` " +
            "JOIN `Rus` ON `Eng-Ru`.`idRus` = `Rus`.`idRus` " +
            "WHERE Eng.English =  ?;";

    private final String SearchRu = "SELECT Eng.English " +
            "FROM `Eng` JOIN `Eng-Ru` ON `Eng`.`idEng` = `Eng-Ru`.`idEng` " +
            "JOIN `Rus` ON `Eng-Ru`.`idRus` = `Rus`.`idRus` " +
            "WHERE Rus.Russians =  ?;";

    private final String SearchEnLike = "select English from Eng where English like ? order by\n" +
            " char_length(English), English asc;";

    private final String SearchRuLike = "select Russians from Rus where Russians like ? order by \n" +
            " char_length(Russians), Russians asc;";

    private final String insertEn = "insert into `Eng` (`English`) values ( ? );";

    private final String insertRu = "insert into `Rus` (`Russians`) values ( ? )";

    private final String insertId = "insert into `Eng-Ru` (`idEng`, `idRus`) values ( ? , ?);";

    private final String searchIdEng = "select idEng from Eng where English = ?;";

    private final String searchIdRus = "select idRus from Rus where Russians = ?;";

    private String command;


    public String getCommand(int number) {
        if (number == 1) {
            command = SearchEn;
        } else if (number == 3) {
            command = SearchRu;
        } else if (number == 2) {
            command = SearchEnLike;
        } else if (number == 4) {
            command = SearchRuLike;
        } else if (number == 5) {
            command = searchIdEng;
        } else if (number == 6) {
            command = searchIdRus;
        } else if (number == 7) {
            command = insertEn;
        } else if (number == 8) {
            command = insertRu;
        } else {
            command =insertId;
        }
        return command;
    }
}
