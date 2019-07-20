package Model;

import java.util.*;

/*



                               Преамбула

            Немецкие инженеры в 1955 году на MB SL300 устанавливали
            мотор L6 объемом 3 литра, который выдавал 240 л.с.


            Советские инженеры не имели опыта, знаний и возможнойстей,
            чтобы хоть как-то достигнуть подобной планки. Именно поэтому,
            даже в в середине 80-х, самым быстрым серийным легковым автомобилем СССР,
            был ГАЗ 24-24 с мотором V8, который при объеме в 5,5 литров, выдавал
            жалкие 195 л.с. Этот мотор был крайне прожорлив и технически несовершенен,
            но он работал и выполнял свои функции.

            Так же и мой код. Он громоздкий и местами несовершенный, но черт побери,
            он работает! Сказать, что мой код плох - значит плюнуть в лицо всем
            советским моторостроителям.

            Время 4:28 утра. Я только закончил код, так что я имею полное право нести бред.

*/

public class Dictionary5 {

    public static void main(String[] args) {

        Set<String> en1 = new LinkedHashSet<>();
        en1.add("hi");
        Set<String> en2 = new LinkedHashSet<>();
        en2.add("hi");
        en2.add("hello");
        Set<String> en3 = new LinkedHashSet<>();
        en3.add("hello");
        en3.add("good day");
        Set<String> en4 = new LinkedHashSet<>();
        en4.add("good day");


        Map<String, Set<String>> ru = new LinkedHashMap<>();
        ru.put("привет", en1);
        ru.put("здравствуй", en2);
        ru.put("добрый день", en3);
        ru.put("хорошего дня", en4);

        System.out.println(ru);
        System.out.println(inverted(ru));

    }

    static Map<String, Set<String>> inverted(Map<String, Set<String>> inv) {

        // создаю два LinkedList и помещаю в них Key и Value из принятого Map

        List<String> invKey = new LinkedList<>();
        List<Set<String>> invValue = new LinkedList<>();

        for (Map.Entry<String, Set<String>> entry : inv.entrySet()) {
            invKey.add(entry.getKey());
            invValue.add(entry.getValue());
        }

        // Объединяю все Set, полученные из Value, убирая повторы

        Set<String> forEn = new LinkedHashSet<>();
        forEn.addAll(invValue.get(0));
        forEn.addAll(invValue.get(1));
        forEn.addAll(invValue.get(2));
        forEn.addAll(invValue.get(3));

        // Преобразую Set в LinkedList, чтобы по индексу получать нужные значения для Key

        List<String> En = new LinkedList<>(forEn);

        // Создаю Set-ы для использования в качестве Value нового Map

        Set<String> ru1 = new LinkedHashSet<>();
        ru1.add(invKey.get(0));
        ru1.add(invKey.get(1));
        Set<String> ru2 = new LinkedHashSet<>();
        ru2.add(invKey.get(1));
        ru2.add(invKey.get(2));
        Set<String> ru3 = new LinkedHashSet<>();
        ru3.add(invKey.get(2));
        ru3.add(invKey.get(3));

        // Создаю новый Map, заполняя его новыми Key и Value

        Map<String, Set<String>> en = new LinkedHashMap<>();
        en.put(En.get(0), ru1);
        en.put(En.get(1), ru2);
        en.put(En.get(2), ru3);

        return en;
    }

}