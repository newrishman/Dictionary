package com.trueSQL.view;

import java.util.Set;

public class OutPuts {

    private final String begin = "Добро пожаловать в словарь! Для поиска слова," +
            "воспользуйтесь командой find + искомое слово. \n" +
            "Для занесения новых слов, воспользуйтесь командой add" +
            " + язык слова (eng/rus) + переводы слова. \n" +
            "Пример поиска: find animal \n" +
            "Пример занесения: add eng animal животное зверь \n" +
            "Введите команду и слово:";
    private final String unknown = "Данное слово отсутствует в словаре.";
    private final String record = "Перевод данного слова успешно записан.";

    public void message(int x) {
String a;
if (x==1){
    a = begin;
} else if (x==2){
    a = unknown;
} else {
    a = record;
}
        System.out.println(a);
    }

    public void translation(String a, String b, Set<?> set) {
        String trans = a + " - " + b + " слово. Перевод: " + set;
        System.out.println(trans);
    }
}
