
package com.dictionary.controller;

import com.dictionary.dao.*;
import com.dictionary.view.OutPuts;
import com.dictionary.model.RussianWord;
import com.dictionary.view.UserInputResult;

import java.util.Set;

public class Controller {

    private String[] inputs;
    private String command;
    private String word;
    private final String enCommand = "SELECT Rus.Russians " +
            "FROM `Eng` JOIN `Eng-Ru` ON `Eng`.`idEng` = `Eng-Ru`.`idEng` " +
            "JOIN `Rus` ON `Eng-Ru`.`idRus` = `Rus`.`idRus` " +
            "WHERE Eng.English = ?;";
    private final String enCommand2 = "select English from Eng where English like '" + word + "%' order by\n" +
            " char_length(English), English asc;";
    private final String ruCommand = "SELECT Eng.English " +
            "FROM `Eng` JOIN `Eng-Ru` ON `Eng`.`idEng` = `Eng-Ru`.`idEng` " +
            "JOIN `Rus` ON `Eng-Ru`.`idRus` = `Rus`.`idRus` " +
            "WHERE Rus.Russians = ?;";
    private final String ruCommand2 = "select Russians from Rus where Russians like '" + word + "%' order by \n" +
            " char_length(Russians), Russians asc;";



    RussianDao rusDao = new RussianDaoJdbc();
    EnglishDao engDao = new EnglishDaoJdbc();
    OutPuts outPuts = new OutPuts();
    UserInputResult userInputResult = new UserInputResult();

    public void input() {
        outPuts.message(1);


        inputs = userInputResult.inputs();
        command = inputs[0];
        word = inputs[1];

        if (command.equalsIgnoreCase("find")) {
            if (ruFind(ruCommand).isEmpty()) {
                if (enFind(enCommand).isEmpty()) {

                } else {
                    outPuts.translation(word, "английское", enFind(enCommand));

                }
            } else {
                outPuts.translation(word, "русское", ruFind(ruCommand));

            }
        } else if (command.equalsIgnoreCase("add")) {

        }
    }

    public Set<RussianWord> ruFind(String command) {

        return rusDao.findByName(command, word);
    }

    public Set<?> enFind(String command) {

        return engDao.findByName(command, word);
    }
}

