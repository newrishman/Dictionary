package Model;

import java.util.*;


public class Dictionary5 {

    public static void main(String[] args) {

        UserInput userInput = new UserInput();
        String word = userInput.input();

        final Set<String> a1 = new LinkedHashSet<>(); //animal
        a1.add("животное");
        a1.add("зверь");
        a1.add("скотина");

        final Map<String, Set<String>> searchRu = new HashMap<>();
        searchRu.put("animal", a1);

/*               Eng - Rus словарь

                             животное
                animal ->    зверь
                             скотина

                Key - animal; Value - животное, зверь, скотина

              теперь делаем Rus - Eng  словарь с теми же данными


                животное
                зверь     ->  animal
                скотина

                Key - животное, Value - animal
                Key - зверь,    Value - animal
                Key - скотина,  Value - animal

                В чем сложность, если ключи разные? В HashMap же могут быть одинаковые значения.


                final Set<String> a1 = new LinkedHashSet<>();
                a1.add("animal");

                final Map<String, Set<String>> инверсия = new HashMap<>();
                инверсия.put("животное", a1);
                инверсия.put("зверь", a1);
                инверсия.put("скотина", a1);

        */


    }
}