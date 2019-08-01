package allDictionary;



import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Dictionary {
    public static void main(String[] args) {

        UserInput userInput = new UserInput();
        String word = userInput.input();


        final Set<String> a1 = new LinkedHashSet<>(); //animal
        a1.add("животное");
        a1.add("зверь");
        a1.add("скотина");
        final Set<String> a2 = new LinkedHashSet<>(); //action
        a2.add("действие");
        a2.add("акция");
        a2.add("деятельность");
        final Set<String> b1 = new LinkedHashSet<>(); //business
        b1.add("бизнес");
        b1.add("дело");
        b1.add("занятие");
        final Set<String> b2 = new LinkedHashSet<>(); //because
        b2.add("потому что");
        b2.add("так как");
        b2.add("ибо");
        final Set<String> c1 = new LinkedHashSet<>(); //civilization
        c1.add("цивилизация");
        c1.add("культура");
        c1.add("цивилизованный мир");
        final Set<String> c2 = new LinkedHashSet<>(); //cock
        c2.add("петух");
        c2.add("кран");
        c2.add("хуй"); // это по словарю!!!
        final Set<String> d1 = new LinkedHashSet<>(); //dickhead
        d1.add("залупа");
        final Set<String> d2 = new LinkedHashSet<>(); //damn
        d2.add("черт");
        d2.add("проклинать");
        d2.add("черт побери");
        final Set<String> e1 = new LinkedHashSet<>(); //enjoy
        e1.add("наслаждаться");
        e1.add("пользоваться");
        e1.add("обладать");
        final Set<String> e2 = new LinkedHashSet<>(); //ecstasy
        e2.add("экстаз");
        e2.add("исступление");
        e2.add("исступленный восторг");
        final Set<String> f1 = new LinkedHashSet<>(); //fuck
        f1.add("блядь");
        f1.add("трахаться");
        f1.add("твою мать");
        final Set<String> f2 = new LinkedHashSet<>(); //flowers
        f2.add("цветочек");
        f2.add("цветок");
        f2.add("цветение");

        Set<Set<String>> rus = new LinkedHashSet<>();
        rus.add(a1);
        rus.add(a2);
        rus.add(b1);
        rus.add(b2);
        rus.add(c1);
        rus.add(c2);
        rus.add(d1);
        rus.add(d2);
        rus.add(e1);
        rus.add(e2);
        rus.add(f1);
        rus.add(f2);


        Map<String, Set<String>> searchRu = new TreeMap<>();
        searchRu.put("action", a2);
        searchRu.put("animal", a1);
        searchRu.put("because", b2);
        searchRu.put("business", b1);
        searchRu.put("civilization", c1);
        searchRu.put("cock", c2);
        searchRu.put("damn", d2);
        searchRu.put("dickhead", d1);
        searchRu.put("ecstasy", e2);
        searchRu.put("enjoy", e1);
        searchRu.put("flowers", f2);
        searchRu.put("fuck", f1);

        // go to Dictionary2
        Map<Set<String>, String> searchEn =
                searchRu.entrySet()
                        .stream()
                        .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));


        if (searchRu.get(word) != null) {
            System.out.println(searchRu.get(word));
        } else {
            for (Set set : rus) {
                if (set.contains(word)) {
                    System.out.println(searchEn.get(set));
                }
            }
        }
    }
}


