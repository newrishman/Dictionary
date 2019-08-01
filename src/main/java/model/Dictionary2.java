package model;


import java.util.TreeMap;
import java.util.stream.Collectors;

import java.util.HashMap;
import java.util.Map;

public class Dictionary2 {
    public static void main(String[] args) {
        Map<String, String> EnRu = new HashMap<>();
        EnRu.put("animal", "животное");
        EnRu.put("boy", "мальчик");

         System.out.println(EnRu.get("animal")); // получим животное

        Map<String, String> RuEn =
                EnRu.entrySet()
                        .stream()
                        .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));

        System.out.println(RuEn.get("мальчик")); // получим  boy


        UserInput userInput = new UserInput();
        String word = userInput.input();

        Map<String, String> EnRuWords = new TreeMap<>();
        EnRuWords.put("action", "a2");
        EnRuWords.put("animal", "a1");
        EnRuWords.put("because", "b2");
        EnRuWords.put("business", "b1");
        EnRuWords.put("civilization", "c1");
        EnRuWords.put("cock", "c2");
        EnRuWords.put("damn", "d2");
        EnRuWords.put("dickhead", "d1");
        EnRuWords.put("ecstasy", "e2");
        EnRuWords.put("enjoy", "e1");
        EnRuWords.put("flowers", "f2");
        EnRuWords.put("fuck", "f1");

        Map<String, String> RusEng = EnRuWords.entrySet()
                .stream()
                .filter(x -> x.getKey().equals(word))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        if (RusEng.get(word) != null) {
            System.out.println(RusEng.get(word));

        } else {
            Map<String, String> EngRus = EnRuWords.entrySet()
                    .stream().filter(x -> x.getValue().equals(word))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

            for (Map.Entry entry : EngRus.entrySet())
                System.out.println(entry.getKey());
        }

    }
}
