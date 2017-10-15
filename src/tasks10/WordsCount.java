package tasks10;

import java.util.*;

public class WordsCount {

    public static void main(String[] args) {
        String[] textArray = {"java", "Java", "javajava", "hello", "java", "world", "hello", "world", "hello!!", "hello", "hello"};
        List<String> text = new ArrayList<>(Arrays.asList(textArray));
        uniqueWords(text);
    }

    public static void uniqueWords(List<String> text) {
        Set<String> uniqueText = new HashSet<>(text);
        for (String uniqueWord : uniqueText) {
            int counter = 0;
            for(String originalWord : text) {
                if(uniqueWord.equals(originalWord)) {
                    counter++;
                }
            }
            System.out.println(uniqueWord + " : " + counter);
        }
    }
}
