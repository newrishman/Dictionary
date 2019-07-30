package Model;

import java.util.*;
import java.util.stream.Collectors;

public class Dictionary7 {
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

        Map<String, Set<String>> dict = ru.entrySet().stream()
                .flatMap(
                        e -> e.getValue().stream()
                                .map(
                                        e1 -> new AbstractMap.SimpleEntry<>(e1, e.getKey())
                                )
                )
                .collect(
                        Collectors.toMap(
                                AbstractMap.SimpleEntry::getKey,
                                e -> new HashSet(Collections.singleton(e.getValue())),
                                (e1, e2) -> {
                                    e1.addAll(e2);
                                    return e1;
                                }
                        )
                );
        System.out.println(dict);
    }

}
