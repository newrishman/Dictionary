package Model;

import java.util.*;

public class Dictionary {
    public static void main(String[] args) {
        UserInput word = new UserInput();



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

        Map<String, Set<String>> search = new TreeMap<>();
        search.put("action", a2);
        search.put("animal", a1);
        search.put("because", b2);
        search.put("business", b1);
        search.put("civilization", c1);
        search.put("cock", c2);
        search.put("damn", d2);
        search.put("dickhead", d1);
        search.put("ecstasy", e2);
        search.put("enjoy", e1);
        search.put("flowers", f2);
        search.put("fuck", f1);

        System.out.println(search.get(word.input()));
    }
}


