package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Words {

    List<String> words = new ArrayList<>();

    private boolean isLowerCase(String word) {
        boolean result = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.trim().charAt(i) >= 97 && word.trim().charAt(i) <= 122) {
                result = true;
            } else {
                return false;
            }
        }
        return result;
    }

    private boolean isOneWord(String word) {
        return word.indexOf(" ") == -1;
    }

    public void addWord(String word) {

        if (isLowerCase(word) && isOneWord(word)) {
            words.add(word);
        } else if (!isOneWord(word)) {
            throw new IllegalArgumentException("It should be one word!");
        } else if (!isLowerCase(word)) {
            throw new IllegalArgumentException("Word should be lower case!");
        }
    }


    public boolean isThereAWordTwice() {
        int count = 0;
        List<String> result = words;
        for (int i = 0; i < result.size(); i++) {
            String word = result.get(i);
            for (String s : words) {
                if (s.equals(word)) {
                    count++;

                    if (count == 2) {
                        return true;
                    }else{
                        return false;
                    }
                }
            }

        }
        return false;

    }

    public List<String> getWords() {
        return words;
    }
}
