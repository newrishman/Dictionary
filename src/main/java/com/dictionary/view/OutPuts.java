package com.dictionary.view;

import java.util.Set;

public class OutPuts {

    public void message(int print) {

        final String begin = "Добро пожаловать в словарь! Для поиска слова," +
                "воспользуйтесь командой find + искомое слово. \n" +
                "Для занесения новых слов, воспользуйтесь командой add" +
                " + язык слова (eng/rus) + переводы слова. \n" +
                "Пример поиска: find animal \n" +
                "Пример занесения: add eng animal животное зверь \n" +
                "Введите команду и слово:";
        final String unknown = "Данное слово отсутствует в словаре.";
        final String record = "Перевод данного слова успешно записан.";


        String a;
        if (print == 1) {
            a = begin;
        } else if (print == 2) {
            a = unknown;
        } else {
            a = record;
        }
        System.out.println(a);
    }

    public void translation(String word, String lang, Set<?> set) {
        String trans = word + " - " + lang + " слово. Перевод: " + set;
        System.out.println(trans);
    }

    public void variants(Set<?> set) {
        final String search = "Такого слова не найдено. Возможно Вы имели ввиду: \n";
        System.out.println(search + " " + set);
    }
}
