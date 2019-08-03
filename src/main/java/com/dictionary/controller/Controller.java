package com.dictionary.controller;

import com.dictionary.dao.*;
import com.dictionary.view.OutPuts;
import com.dictionary.model.RussianWord;
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
            // поиск введенного английского слова в словаре
            set=enFind(1);
            if (!set.isEmpty()) {
                outPuts.translation(word, "английское", set);
            } else {
                // поиск английских слов, похожих на введенное
                set=enFind(3);
                if (!set.isEmpty()) {
                    outPuts.translation(set);
                } else {
                    // поиск введенного русского слова в словаре
                    set=ruFind(2);
                    if (!set.isEmpty()) {
                        outPuts.translation(word, "русское", set);
                    } else {
                        // поиск русских слов, похожих на введенное
                        set=ruFind(4);
                        if (!set.isEmpty()) {
                            outPuts.translation(set);
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

