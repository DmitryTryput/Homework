package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckLength {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("this", "is", "lots", "of", "fun", "ffff", "for", "every", "Java", "programmer"));
        markLength4(list);
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static void markLength4(List<String> list) {
        List<String> wantedWords = new ArrayList<>();
        for (String word : list) {
            if (word.length() == 4) {
                wantedWords.add(word);
            }
        }
        for (String word : wantedWords) {
            list.add(list.indexOf(word), "****");
        }
    }
}
