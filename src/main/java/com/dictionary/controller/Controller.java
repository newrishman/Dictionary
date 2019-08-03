package com.dictionary.controller;

import com.dictionary.dao.*;
import com.dictionary.service.Service;
import com.dictionary.view.OutPuts;
import com.dictionary.model.RussianWord;
import com.dictionary.view.UserInputResult;

import java.util.Set;

public class Controller {

    private String[] inputs;
    private String command;
    private String word;

    private RussianDao rusDao = new RussianDaoJdbc();
    private EnglishDao engDao = new EnglishDaoJdbc();
    private RusRecordDao rusRecordDao = new RusRecordDaoJdbc();
    private EngRecordDao engRecordDao = new EngRecordDaoJdbc();
    private OutPuts outPuts = new OutPuts();
    private UserInputResult userInputResult = new UserInputResult();


    public void translation() {

        outPuts.message(1);

        inputs = userInputResult.inputs();
        command = inputs[0];
        word = inputs[1];

        // команда 1 - поиск введенного английского слова в словаре
        // команда 2 - поиск введенного русского слова в словаре
        // команда 3 - поиск английских слов, похожих на введенное
        // команда 4 - поиск русских слов, похожих на введенное

        if (command.equalsIgnoreCase("find")) {

            if (!enFind(1).isEmpty()) {
                outPuts.translation(word, "английское", enFind(1));
            } else {
                if (!enFind(3).isEmpty()) {
                    outPuts.variants(enFind(3));
                } else {
                    if (!ruFind(2).isEmpty()) {
                        outPuts.translation(word, "русское", ruFind(2));
                    } else {
                        if (!ruFind(4).isEmpty()) {
                            outPuts.variants(ruFind(4));
                        } else {
                            outPuts.message(2);
                        }
                    }
                }
            }
        } else if (command.equalsIgnoreCase("add")) {

            if (word.equalsIgnoreCase("eng")) {
                recordEn();
            } else if (word.equalsIgnoreCase("rus")) {
                recordRu();
            } else {
                outPuts.message(6);
            }
            outPuts.message(3);
        } else {
            outPuts.message(4);
        }
    }

    public Set<RussianWord> ruFind(int com) {

        return rusDao.findByName(com, word);
    }

    public Set<?> enFind(int com) {

        return engDao.findByName(com, word);
    }

    public void recordRu() {
        rusRecordDao.record(inputs);
    }

    public void recordEn() {
        engRecordDao.record(inputs);
    }
}

