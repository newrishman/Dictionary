package com.dictionary.view;

import java.util.Set;

public class OutPuts {

    public void message(int print) {

        final String begin = "Добро пожаловать в словарь! Для поиска слова," +
                "воспользуйтесь командой find + искомое слово. " +
                "Для занесения новых слов, воспользуйтесь командой \nadd" +
                " + язык слова (eng/rus) + новое слово + переводы слова. \n" +
                "Пример поиска: find animal    " +
                "Пример занесения: add eng animal животное зверь. \n" +
                "Введите команду и слово:";
        final String unknown = "Данное слово отсутствует в словаре. Вы можете записать это слово в словарь.";
        final String unkCommand = "Введена некорректная команда!";
        final String record = "Перевод данного слова записан.";
        final String langError = "Неправильно введен язык записываемого слова";


        String a;
        if (print == 1) {
            a = begin;
        } else if (print == 2) {
            a = unknown;
        } else if (print == 3) {
            a = record;
        } else if (print == 4) {
            a = unkCommand;
        } else {
            a = langError;
        }
        System.out.println(a);
    }

    public void translation(String word, String lang, Set<?> set) {
        String trans = word + " - " + lang + " слово. Перевод: " + set;
        System.out.println(trans);
    }

    public void translation(Set<?> set) {
        final String search = "Такого слова не найдено. Возможно Вы имели ввиду: \n";
        System.out.println(search + " " + set);
    }
}
