package Model;

import java.util.*;

public class Dictionary6 {
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
        System.out.println(invert(ru));
    }

    public static Map<String, Set<String>> invert(Map<String, Set<String>> inv) {

        Map<String, Set<String>> newMap = new LinkedHashMap<>();


        for (Map.Entry<String, Set<String>> entry : inv.entrySet()) {

            for (String string : entry.getValue()) {

                if (newMap.containsKey(string)) {

                    Set<String> newSet = new LinkedHashSet(newMap.get(string));
                    newSet.add(entry.getKey());
                    newMap.put(string, newSet);

                } else {
                    newMap.put(string, Collections.singleton(entry.getKey()));
                }
            }
        }
        return newMap;
    }
}
