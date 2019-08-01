
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

    RussianDao rusDao = new RussianDaoJdbc();
    EnglishDao engDao = new EnglishDaoJdbc();
    OutPuts outPuts = new OutPuts();


    public void input() {
        outPuts.message(1);
        UserInputResult userInputResult = new UserInputResult();

        inputs = userInputResult.inputs();
        command = inputs[0];
        word = inputs[1];

        if (command.equalsIgnoreCase("find")) {
            if (ruFind(word).isEmpty()) {
                if (enFind(word).isEmpty()) {
                    outPuts.message(2);
                } else {
                    outPuts.translation(word, "английское", enFind(word));

                }
            } else {
                outPuts.translation(word, "русское", ruFind(word));

            }
        } else if (command.equalsIgnoreCase("add")) {

        }
    }

    public Set<RussianWord> ruFind(String word) {

        return rusDao.findByName(word);
    }

    public Set<?> enFind(String word) {

        return engDao.findByName(word);
    }
}

