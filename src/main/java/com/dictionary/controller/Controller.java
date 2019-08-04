package com.dictionary.controller;

import com.dictionary.dao.*;
import com.dictionary.view.OutPuts;
import com.dictionary.view.UserInputResult;

import java.util.Set;

public class Controller {

    private Set<?> set;
    private String word;
    private String command;
    private String[] inputs;

    private OutPuts outPuts = new OutPuts();
    private RussianDao rusDao = new RussianDaoJdbc();
    private EnglishDao engDao = new EnglishDaoJdbc();
    private RusRecordDao rusRecordDao = new RusRecordDaoJdbc();
    private EngRecordDao engRecordDao = new EngRecordDaoJdbc();
    private UserInputResult userInputResult = new UserInputResult();


    public void dictionary() {

        outPuts.message(1);

        inputs = userInputResult.inputs();
        command = inputs[0];
        word = inputs[1];

        if (command.equalsIgnoreCase("find")) {

            if (!enFind(1)) {
                if (!ruFind(3)) {
                    outPuts.message(2);
                }
            }

        } else if (command.equalsIgnoreCase("add")) {

            if (recordWord(inputs[2]))
                outPuts.message(3);

        } else {
            outPuts.message(4);
        }
    }



    private boolean ruFind(int com) {
        // поиск слова - команда #3
        set = rusDao.findByName(com, word);
        if (!set.isEmpty()) {
            outPuts.translation(word, "русское", set);
            return true;
            // поиск похожего слова  - команда #4
        } else com = com + 1;
        set = rusDao.findByName(com, word);
        if (!set.isEmpty()) {
            outPuts.translation(set);
            return true;
        }

        return false;
    }

    private boolean enFind(int com) {
        // поиск слова - команда #1
        set = engDao.findByName(com, word);
        if (!set.isEmpty()) {
            outPuts.translation(word, "английское", set);
            return true;
            // поиск слова - команда #2
        } else com = com + 1;
        set = engDao.findByName(com, word);
        if (!set.isEmpty()) {
            outPuts.translation(set);
            return true;
        }
        return false;
    }

    private boolean recordWord(String lang) {
        if (lang.equalsIgnoreCase("eng")) {
            engRecordDao.record(inputs);
            return true;
        } else if (lang.equalsIgnoreCase("rus")) {
            rusRecordDao.record(inputs);
            return true;
        } else {
            outPuts.message(5);
            return false;
        }
    }
}

