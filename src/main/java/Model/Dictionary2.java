package Model;

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

    }
}
