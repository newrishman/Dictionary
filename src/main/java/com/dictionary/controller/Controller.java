
package com.dictionary.controller;

import com.dictionary.dao.*;
import com.dictionary.view.OutPuts;
import com.dictionary.model.RussianWord;
import com.dictionary.view.UserInputResult;

import java.util.Set;

public class Controller {

    private String word;

    private RussianDao rusDao = new RussianDaoJdbc();
    private EnglishDao engDao = new EnglishDaoJdbc();
    private OutPuts outPuts = new OutPuts();
    private UserInputResult userInputResult = new UserInputResult();


    public void input() {
        String[] inputs;
        String command;

        outPuts.message(1);

        inputs = userInputResult.inputs();
        command = inputs[0];
        word = inputs[1];


        if (command.equalsIgnoreCase("find")) {

            System.out.println(ruFind(2));

        } else if (command.equalsIgnoreCase("add")) {

        }
    }

    public Set<RussianWord> ruFind(int com) {

        return rusDao.findByName(com, word);
    }

    public Set<?> enFind(int com) {

        return engDao.findByName(com, word);
    }
}

