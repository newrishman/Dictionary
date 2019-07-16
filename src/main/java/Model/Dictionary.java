package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {

    public void dictionary(String word) {


        final List<String> a1 = new ArrayList<>(); //animal
        a1.add("животное");
        a1.add("зверь");
        a1.add("скотина");
        final List<String> a2 = new ArrayList<>(); //action
        a2.add("действие");
        a2.add("акция");
        a2.add("деятельность");
        final List<String> b1 = new ArrayList<>(); //business
        b1.add("бизнес");
        b1.add("дело");
        b1.add("занятие");
        final List<String> b2 = new ArrayList<>(); //because
        b2.add("потому что");
        b2.add("так как");
        b2.add("ибо");
        final List<String> c1 = new ArrayList<>(); //civilization
        c1.add("цивилизация");
        c1.add("культура");
        c1.add("цивилизованный мир");
        final List<String> c2 = new ArrayList<>(); //cock
        c2.add("петух");
        c2.add("кран");
        c2.add("хуй"); // это по словарю!!!
        final List<String> d1 = new ArrayList<>(); //dickhead
        d1.add("залупа");
        final List<String> d2 = new ArrayList<>(); //damn
        d2.add("черт");
        d2.add("проклинать");
        d2.add("черт побери");
        final List<String> e1 = new ArrayList<>(); //enjoy
        e1.add("наслаждаться");
        e1.add("пользоваться");
        e1.add("обладать");
        final List<String> e2 = new ArrayList<>(); //ecstasy
        e2.add("экстаз");
        e2.add("исступление");
        e2.add("исступленный восторг");
        final List<String> f1 = new ArrayList<>(); //fuck
        f1.add("блядь");
        f1.add("трахаться");
        f1.add("твою мать");
        final List<String> f2 = new ArrayList<>(); //flowers
        f2.add("цветочек");
        f2.add("цветок");
        f2.add("цветение");

        Map<String, List<String>> search = new HashMap<>();
        search.put("animal", a1);
        search.put("action", a2);
        search.put("business", b1);
        search.put("because", b2);
        search.put("civilization", c1);
        search.put("cock", c2);
        search.put("dickhead", d1);
        search.put("damn", d2);
        search.put("enjoy", e1);
        search.put("ecstasy", e2);
        search.put("fuck", f1);
        search.put("flowers", f2);

        System.out.println(search.get(word));

    }
}

